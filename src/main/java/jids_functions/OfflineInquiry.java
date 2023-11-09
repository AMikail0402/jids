package jids_functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapHandle.TimestampPrecision;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapPacket;
import org.pcap4j.core.Pcaps;
import org.pcap4j.util.NifSelector;

import jids.Objects.Rule;
import jids.util.RegexSearch;
import jids.util.RuleSetGenerator;



public class OfflineInquiry extends Thread {



       public static void offlineAnalysis(BufferedReader br) throws PcapNativeException, NotOpenException, IOException{   
            
        Long begin = new Date().getTime();
            System.setProperty("log4j.configurationFile","./resources/log4j2.xml");

         
            PcapHandle handle;
             try {
                handle = Pcaps.openOffline("test.pcap", TimestampPrecision.NANO);
            } catch (PcapNativeException e) {
                handle = Pcaps.openOffline("test.pcap");
            }
            // Open the Device and get a handle
          
                
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
                threading(handle, maxPackets, listener);
                
            } 
            catch (InterruptedException e) {
                    e.printStackTrace();
                }
         
            handle.close();
            Long end = new Date().getTime();
            Long total = end-begin;
             System.out.println("Die Untersuchung hat "+total+" Millisekunden gedauert");
            }
            
            static void threading(PcapHandle handle, int maxPackets, PacketListener listener) throws InterruptedException{
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