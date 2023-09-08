package jids.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageExtractor{
        static String basicMessage = "TCP source-ip any dest-ip 10.0.0.10 source-port any dest-port 8082 (msg:'Das Gras ist grün')";
        String messagePattern ="msg:'(.*)'";
        public static void main(String[] args){
               getMessage(basicMessage);
        }
        
        public static String getMessage(String rule){
                System.out.println(rule);
                String messagePattern ="msg:'(.*)'";
                Pattern pattern = Pattern.compile(messagePattern);
                Matcher matcher = pattern.matcher(rule);
                matcher.find();
                String message = matcher.group(1);
                return message;
        }

}