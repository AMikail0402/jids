package jids;

import jids.util.RulePatternGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        System.out.println( RulePatternGenerator.totalRule("TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082"));
    }
}
