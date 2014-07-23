package com.hele.commons.codec;


import com.hele.commons.SystemVariableUtils;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ning on 2014/7/2 0002.
 */
public class HmacSHA256Utils {

    public static String digest(String key, String content) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] secretByte = key.getBytes("utf-8");
            byte[] dataBytes = content.getBytes("utf-8");

            SecretKey secret = new SecretKeySpec(secretByte, "HMACSHA256");
            mac.init(secret);

            byte[] doFinal = mac.doFinal(dataBytes);
            byte[] hexB = new Hex().encode(doFinal);
            return new String(hexB, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String mapToString(Map<String, ?> map){
        StringBuilder s = new StringBuilder();
        for(Object values : map.values()) {
            if(values instanceof String[]) {
                for(String value : (String[])values) {
                    s.append(value);
                }
            } else if(values instanceof List) {
                for(String value : (List<String>)values) {
                    s.append(value);
                }
            } else {
                s.append(values);
            }
        }
        return s.toString();
    }
    public static String digest(String key, Map<String, ?> map) {
        StringBuilder s = new StringBuilder();
        for(Object values : map.values()) {
            if(values instanceof String[]) {
                for(String value : (String[])values) {
                    s.append(value);
                }
            } else if(values instanceof List) {
                for(String value : (List<String>)values) {
                    s.append(value);
                }
            } else {
                s.append(values);
            }
        }
        System.out.println(s.toString());
        return digest(key, s.toString());
    }

    public static void main(String[] args){
        String username = "wsis12345678";
        String param12 = "wyh9zLJZNbDvti";
        String key = "ao1QHiti";
        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("uuid", param12);
        params.put("username", username);
        params.put("authcode", key);

        //params.put("clientDigest", "990d37b9d6aecb24d77ad3a086a0e1c57a0b32a03ddbb5ca55f67c4eefd0f374");
        System.out.println(HmacSHA256Utils.digest(key, params));
        System.out.println(HmacSHA256Utils.digest(key, "wyh9zLJZNbDvtiwsis12345678ao1QHiti"));
    }
}
