package jids.ObjectTest;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;

import jids.Objects.Rule;

public class RuleObjectTest {
   
   static Rule spyRule = spy(new Rule(null,null,null,null));

 

    @org.junit.jupiter.api.Test
    public void ruleToStringTest(){

        spyRule.setCve("cve");
        spyRule.setId("1");
        spyRule.setMsg("msg");
        spyRule.setPattern("pattern");
        
        Assertions.assertEquals("pattern | msg | cve | 1",spyRule.toString());
    }
    
}
