package jids;

import java.beans.beancontext.BeanContextChildSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        FileInputStream fis = new FileInputStream("rules.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println(line);
       // System.out.println( RulePatternGenerator.totalRule("TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082"));
    }
}
