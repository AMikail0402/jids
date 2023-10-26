package jids.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Stack;

import jids.Objects.Rule;

public class RuleSetGenerator {
        public static void main(String[] args) throws IOException{
                // String rulexample = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'grün'; cve:'CVE-2023-1237'; id:'1')";
                // String ruleSetExample = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'grün'; cve:'CVE-2023-1237'; id:'1')\r\n" + //
                //                 "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'blau'; cve:'CVE-2023-1239'; id:'2')\r\n" + //
                //                 "";
                // Rule ruleObject = createRule(rulexample);
                // System.out.println(ruleSetExample);
                FileInputStream fis = new FileInputStream("./jids/rules.conf");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
            }
        


        public static Rule createRule(String fullRule){
                String pattern = RulePatternGenerator.totalRule(fullRule);
                String cve = CveExtractor.getCve(fullRule);
                String msg = MessageExtractor.getMessage(fullRule);
                String id = IdExtractor.getId(fullRule);
                Rule rule = new Rule(pattern, msg, cve, id);
                return rule;
        }

        public static Rule[] createRuleSet(BufferedReader br) throws IOException{
        Stack<Rule> rules = new Stack<Rule>();
                while(true){
                if(br.ready()){
                String cur = br.readLine();
                Rule currentRule = createRule(cur);
                System.out.println("Regel"+currentRule.toString());
                rules.push(currentRule);
                }
                else{
                        break;
                }
                }
        int size = rules.size();
        System.out.println("Größe"+size);
        Rule[] ruleArray = new Rule[size];
        rules.copyInto(ruleArray);
        return ruleArray;
        }
}
