package com.hele.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ning on 2014/7/2 0002.
 */
public class StringUtils {

    public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
