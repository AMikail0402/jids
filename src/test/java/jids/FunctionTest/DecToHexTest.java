package jids.FunctionTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

import jids.util.Converter;

public class DecToHexTest {
    
   @org.junit.jupiter.api.Test
    public void singleDigitTest(){
        Assertions.assertEquals("01",Converter.decToHex("1"));
        Assertions.assertEquals("07",Converter.decToHex("7"));
    }
     @org.junit.jupiter.api.Test
    public void doubleDigitTest(){
        Assertions.assertEquals("0A",Converter.decToHex("10"));
        Assertions.assertEquals("15",Converter.decToHex("21"));
    }
    @org.junit.jupiter.api.Test
    public void zeroTest(){
        Assertions.assertEquals("00",Converter.decToHex("0"));
    }

}
