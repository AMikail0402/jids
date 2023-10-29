package jids.ObjectTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

import jids.Objects.Rule;

public class RuleObjectTest {
   @Mock
   static Rule rule = new Rule("msg","pattern","cve","1");

    @Test
    public void ruleToStringTest(){
        assertEquals("msg | pattern | cve | 1",rule.toString());
    }
    
}
