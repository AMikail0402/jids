package jids.FunctionTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

import jids.Objects.Rule;
import jids.util.RuleSetGenerator;

public class RuleSetGeneratorTest {

    public static void main(String[] args) throws IOException{
            FileInputStream fis = new FileInputStream("./jids/src/test/java/jids/FunctionTest/test.conf");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = RuleSetGenerator.createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
    }

    @Test
    public void ruleArrayGeneratorTest() throws IOException{
            
                FileInputStream fis = new FileInputStream("./src/test/java/jids/FunctionTest/test.conf");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                Rule[] ruleArray = RuleSetGenerator.createRuleSet(br);
                for(Rule x : ruleArray){
                        System.out.println("Eine Regel"+x.toString());
                }
            
                Assert.assertEquals("Die ID der ersten Regel ","1",ruleArray[0].getId());
                Assert.assertEquals("Die Nachricht der ersten Regel ","grün",ruleArray[0].getMsg());
                Assert.assertEquals("Die CVE der ersten Regel ","CVE-2023-1237",ruleArray[0].getCve());
                Assert.assertEquals("Pattern der ersten Regel ","06(?:.|\\n){7}((?:.|\\n){12})(0a(?:.|\\n)00(?:.|\\n)00(?:.|\\n)0a) ((?:.|\\n){6})(1f 92)",ruleArray[0].getPattern());
                
                Assert.assertEquals("Die ID der zweiten Regel ","2",ruleArray[1].getId());
                Assert.assertEquals("Die Nachricht der zweiten Regel ","msg2",ruleArray[1].getMsg());
                Assert.assertEquals("Die CVE der zweiten Regel ","CVE-2022-1235",ruleArray[1].getCve());
                Assert.assertEquals("Pattern der zweiten Regel ","06(?:.|\\n){7}((?:.|\\n){12})(0a(?:.|\\n)00(?:.|\\n)00(?:.|\\n)0a) (d1 3a) (1f 90)",ruleArray[1].getPattern());
    }


}
