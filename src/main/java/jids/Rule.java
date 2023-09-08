package jids;

import jids.util.RulePatternGenerator;

public class Rule {

    String pattern;
    String msg;
    String cve;

    Rule(String pattern,String msg, String cve){

        this.pattern = pattern;
        this.msg = msg;
        this.cve = cve;

    }

    public Rule patternGenerate(String rule){
        this.pattern = RulePatternGenerator.totalRule(rule);
        
        return this;
    }

    public String toString(){ 
        return pattern+" | "+msg+" | "+cve;  
       }  
}
