package jids;

import jids.util.RulePatternGenerator;

public class Rule {

    String pattern;
    String msg;
    String cve;
    String id;

    public Rule(String pattern,String msg, String cve, String id){

        this.pattern = pattern;
        this.msg = msg;
        this.cve = cve;
        this.id = id;

    }

    public Rule patternGenerate(String rule){
        this.pattern = RulePatternGenerator.totalRule(rule);
        
        return this;
    }

    public String toString(){ 
        return pattern+" | "+msg+" | "+cve+" | "+id;  
       }  
}
