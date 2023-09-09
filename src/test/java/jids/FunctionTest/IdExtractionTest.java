package jids.FunctionTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import jids.util.CveExtractor;
import jids.util.IdExtractor;


public class IdExtractionTest {
    String ruleOne = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (cve:'CVE-2023-2232'; id:'1')";
   
    @Test
    public void cveTest(){
        assertEquals("1",IdExtractor.getCve(ruleOne));
    }

    @Test
    public void readIdOutOfFile() throws IOException{

        FileInputStream fis = new FileInputStream("./src/test/java/jids/FunctionTest/test.conf");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String lineOne = br.readLine();
        assertEquals("1", IdExtractor.getCve(lineOne));
        String lineTwo = br.readLine();
        assertEquals("2", IdExtractor.getCve(lineTwo));
    
    }


}
