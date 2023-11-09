package jids_functions;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
