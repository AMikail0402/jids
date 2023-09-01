package jids.util;

public class Rule {

    String pattern;
    String msg;
    String cve;

    Rule(String pattern,String msg, String cve){

        this.pattern = pattern;
        this.msg = msg;
        this.cve = cve;

    }

    public String toString(){ 
        return pattern+" | "+msg+" | "+cve;  
       }  
}
