package jids.ObjectTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jids.Rule;

public class RuleObjectTest {
    
    @Test
    public void ruleToStringTest(){
        Rule rule1 = new Rule("msg","pattern","cve");
        assertEquals("msg | pattern | cve",rule1.toString());
    }
    
}
