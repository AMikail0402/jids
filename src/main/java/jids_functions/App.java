package jids_functions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapNativeException;

import api.DbCheck;

/**
 * Hello world!
 *
 */

public class App 
{ 
    static String startUpLogo = "     //   //  //////    /////\r\n" + //
            "    //   //  //   //   //     \r\n" + //
            "   //   //  //   //      //  \r\n" + //
            "////   //  //////    /////";

    public static void main( String[] args ) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException, PcapNativeException, NotOpenException
    {
      startUpSequence(startUpLogo);
     
      LocalDateTime dateTime = LocalDateTime.now();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
      String formattedTime = dateTime.format(dateTimeFormatter);
      DbCheck.isAvailable();
      UserLoop.startUp();
    
    }

    public static void startUpSequence(String logo) throws InterruptedException{
      char[] chars = logo.toCharArray();
      for(char x : chars){
        System.out.print(x);
        Thread.sleep(10);
      }
        System.out.println();
    }
}
