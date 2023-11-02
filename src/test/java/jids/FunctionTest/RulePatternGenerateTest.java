package jids.FunctionTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jids.util.RulePatternGenerator;

public class RulePatternGenerateTest {
    private String validRulePattern1 = "06(?:.|\\n){7}(c0(?:.|\\n)a8(?:.|\\n)38(?:.|\\n)01) (c0(?:.|\\n)a8(?:.|\\n)38(?:.|\\n)67) (f3 ca) (00 16)";
    private String validTestRule1 = "TCP source-ip 192.168.56.1 dest-ip 192.168.56.103 source-port 62410 dest-port 22";
    
    private String zeroPattern = "06(?:.|\\n){7}((?:.|\\n){12})(0a(?:.|\\n)00(?:.|\\n)00(?:.|\\n)0a) ((?:.|\\n){6})(1f 92)";
    private String zeroRule = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082";

    @Test
    public void tcpRulePatternGenerationConsistencyTest()
    {
        Assertions.assertEquals(validRulePattern1, RulePatternGenerator.totalRule(validTestRule1));
    }
      @Test
    public void zeroConsistencyTest()
    {
        Assertions.assertEquals(zeroPattern, RulePatternGenerator.totalRule(zeroRule));
    }
    
}
