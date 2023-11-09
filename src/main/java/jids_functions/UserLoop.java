package jids_functions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;

import api.DbCheck;

class UserLoop{
   

    public static void startUp() throws PcapNativeException, NotOpenException, IOException{
        boolean db = DbCheck.isAvailable();
        System.out.println("Was wollen sie tun? Online-Filtering: on; Offline-Filtering: off; Auswertung: analysis");
        Scanner myScanner = new Scanner(System.in);
        String answer = myScanner.nextLine().toLowerCase();

        FileInputStream fis = new FileInputStream("./rules.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        
        if(answer.equals("on")){
            OnlineInquiry.onlineAnalysis(br,db);
        }
        if(answer.equals("off")){
            OfflineInquiry.offlineAnalysis(br);
        }
    }
}