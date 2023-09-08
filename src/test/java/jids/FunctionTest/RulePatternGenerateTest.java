package jids.FunctionTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jids.util.RulePatternGenerator;

public class RulePatternGenerateTest {
    private String validRulePattern = "06(?:.|\\n){7}(c0(?:.|\\n)a8(?:.|\\n)38(?:.|\\n)01) (c0(?:.|\\n)a8(?:.|\\n)38(?:.|\\n)67) (f3 ca) (00 16)";
    private String validTestRule = "TCP source-ip 192.168.56.1 dest-ip 192.168.56.103 source-port 62410 dest-port 22";



     @Test
    public void tcpRulePatternGenerationConsistencyTest()
    {
        assertEquals(validRulePattern, RulePatternGenerator.totalRule(validTestRule));
    }
    
    
}
