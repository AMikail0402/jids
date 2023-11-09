package jids_functions;

import java.io.BufferedReader;
import java.io.IOException;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.PcapPacket;
import org.pcap4j.core.PcapStat;
import org.pcap4j.util.NifSelector;

import jids.Objects.Rule;
import jids.util.RegexSearch;
import jids.util.RuleSetGenerator;



public class OnlineInquiry{

       public static void onlineAnalysis(BufferedReader br) throws PcapNativeException, NotOpenException, IOException{   
           PcapNetworkInterface device = getNetworkDevice();
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
                   for(Rule x : ruleSet){
                        String pattern = x.getPattern();
                        boolean keyword = RegexSearch.search(packet.toHexString(), pattern);
                        if(keyword == true){
                            System.out.println("Match!\n\n");
                        }
                    }
                    
                }
                
            };


            try {
                int maxPackets = (int)(Math.pow(10, 5));
                handle.loop(maxPackets, listener);
            } 
            catch (InterruptedException e) {
                    e.printStackTrace();
                }

            PcapStat stats = handle.getStats();
            System.out.println("Packets received: " + stats.getNumPacketsReceived());
            System.out.println("Packets dropped: " + stats.getNumPacketsDropped());
            System.out.println("Packets dropped by interface: " + stats.getNumPacketsDroppedByIf());
            handle.close();

            }

            static PcapNetworkInterface getNetworkDevice() {
            PcapNetworkInterface device = null;
            try {
                device = new NifSelector().selectNetworkInterface();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return device;
        }


}