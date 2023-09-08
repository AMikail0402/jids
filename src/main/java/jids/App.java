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
       
        System.out.println( RulePatternGenerator.totalRule("TCP source-ip 192.168.56.1 dest-ip 192.168.56.103 source-port 62410 dest-port 22"));
    }
}
