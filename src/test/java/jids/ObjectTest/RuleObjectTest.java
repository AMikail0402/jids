package jids.ObjectTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jids.Objects.Rule;

public class RuleObjectTest {
    
    @Test
    public void ruleToStringTest(){
        Rule rule1 = new Rule("msg","pattern","cve","1");
        assertEquals("msg | pattern | cve | 1",rule1.toString());
    }
    
}
