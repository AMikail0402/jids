package jids;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.*;
/**
 * Hello world!
 *
 */
public class App 
{ 
    static Logger logger = LogManager.getLogger(App.class.getName());

    static String startUpLogo = "     //   //  //////    /////\r\n" + //
            "    //   //  //   //   //     \r\n" + //
            "   //   //  //   //      //  \r\n" + //
            "////   //  //////    /////";

    public static void main( String[] args ) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException
    {
      LocalDateTime dateTime = LocalDateTime.now();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
      String formattedTime = dateTime.format(dateTimeFormatter);
      logger.info("Logging");
   
    

     //startUpSequence(startUpLogo);
     /*   FileInputStream fis = new FileInputStream("rules.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        Object[] strArray = br.lines().toArray();

        for(Object x : strArray){
            System.out.println(x.toString());
            System.out.println(MessageExtractor.getMessage(x.toString()));
        }

       // System.out.println( RulePatternGenerator.totalRule("TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082"));
     */
    
   
    }

    public static void startUpSequence(String logo) throws InterruptedException{
      char[] chars = logo.toCharArray();
      for(char x : chars){
        System.out.print(x);
        Thread.sleep(10);
      }
        
    }
}
