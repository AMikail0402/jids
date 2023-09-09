package jids.util;

import java.io.BufferedReader;

import jids.Rule;

public class RuleSetGenerator {
        public static void main(String[] args){
                String rulexample = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'grün'; cve:'CVE-2023-1237'; id:'1')";
                Rule ruleObject = createRule(rulexample);
                System.out.println(ruleObject.toString());
            }
        


        public static Rule createRule(String fullRule){
                String pattern = RulePatternGenerator.totalRule(fullRule);
                String cve = CveExtractor.getCve(fullRule);
                String msg = MessageExtractor.getMessage(fullRule);
                String id = IdExtractor.getId(fullRule);
                Rule rule = new Rule(pattern, msg, cve, id);
                return rule;
        }

        public static Rule[] createRuleSet(BufferedReader br){
            return null;
        }
}
