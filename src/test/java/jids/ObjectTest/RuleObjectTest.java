package jids.ObjectTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import jids.Objects.Rule;

public class RuleObjectTest {
   @Mock
   static Rule rule = mock(Rule.class);

   @BeforeAll
   public static void setUp(){
    when(rule.getCve()).thenReturn("cve");
    when(rule.getId()).thenReturn("1");
    when(rule.getMsg()).thenReturn("msg");
    when(rule.getPattern()).thenReturn("pattern");
    when(rule.toString()).thenReturn("pattern | msg | cve | 1");
   }

    @org.junit.jupiter.api.Test
    public void ruleToStringTest(){
       Assertions.assertEquals("pattern | msg | cve | 1",rule.toString());
    }
    
}
