package jids.FunctionTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jids.util.Converter;

public class DecToHexTest {
    
    @Test
    public void singleDigitTest(){
        assertEquals("01",Converter.decToHex("1"));
        assertEquals("07",Converter.decToHex("7"));
    }
     @Test
    public void doubleDigitTest(){
        assertEquals("0A",Converter.decToHex("10"));
        assertEquals("15",Converter.decToHex("21"));
    }
       @Test
    public void zeroTest(){
        assertEquals("00",Converter.decToHex("0"));
        
    }

}
