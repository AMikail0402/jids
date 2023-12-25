package jids_functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapAddress;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.core.PcapPacket;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.NifSelector;

import api.DbPush;
import jids.Objects.Rule;
import jids.util.RegexSearch;
import jids.util.RuleSetGenerator;



public class OnlineInquiry{

    

       public static void onlineAnalysis(BufferedReader br, boolean db,String address) throws PcapNativeException, NotOpenException, IOException{   

            System.setProperty("log4j.configurationFile","./resources/log4j2.xml");


            PcapNetworkInterface device = getNetworkDevice(address);
            System.out.println("You chose: " + device);

            if(device == null ){
                System.out.println("No device chosen");
                System.exit(1);
            }
            
            final PcapHandle handle;
            // Open the Device and get a handle
            int snapshotLength = 65536;
            int readTimeout = 50;
            handle = device.openLive(snapshotLength, PromiscuousMode.PROMISCUOUS, readTimeout);
            
            //Create Rule Array 
            final Rule[] ruleSet = RuleSetGenerator.createRuleSet(br);

            // Create a listener that defines what to do with the received packets
            PacketListener listener = new PacketListener() {

                @Override
                public void gotPacket(PcapPacket packet) {
                    System.out.println(packet.toHexString());
                  
                    IpV4Packet ipacket = packet.get(IpV4Packet.class);

                   for(Rule x : ruleSet){

                        String pattern = x.getPattern();
                        threadingRegex(x, packet.toHexString(), pattern, db, ipacket);

                    }
                    
                }
                
            };


            try {
                int maxPackets = (int)(Math.pow(10, 7));
                handle.loop(maxPackets,listener);
            } 
            catch (InterruptedException e) {
                    e.printStackTrace();
                }
                      
            }

            static void threadingRegex(Rule x, String input, String pattern, boolean db,IpV4Packet ipacket ){
                     
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                        boolean keyword  = RegexSearch.search(input, pattern);
                          if(keyword == true){

                         System.out.println("Match!\n\n");
                        if(db){
                                try {
                                    DbPush.push(x.getCve(), x.getMsg(),new Date().toString(), ipacket.getHeader().getSrcAddr().toString());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    System.out.println("Datenbank konnte nicht erreicht werden !");
                                }
                            }
                            
                        }
                    }
                };
                thread.start();
            }

            static void threadingHandle(PcapHandle handle, int maxPackets, PacketListener listener) throws InterruptedException{
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                       try {
                        handle.loop(maxPackets, listener);
                    } catch (PcapNativeException | InterruptedException | NotOpenException e) {
                        e.printStackTrace();
                    }
                    }
                };
                thread.start();    
            }

            static PcapNetworkInterface getNetworkDevice(String address) throws PcapNativeException {
                PcapNetworkInterface device = null;
            
                List<PcapNetworkInterface> devices = Pcaps.findAllDevs();
            
                
                for(PcapNetworkInterface x : devices){
                   List<PcapAddress> addr = x.getAddresses();
                   for(PcapAddress p : addr){
                    System.out.println("Die Addresse "+p.getAddress());
                    if(p.getAddress().toString().replaceAll("\\/", "").equals(address)){
                        device = x;
                    }
                   }
                }
              
           
         
            return device;
        }


}