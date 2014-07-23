package com.hele.commons;

import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ning on 2014/7/2 0002.
 */
public class ServletUtils {

    public static Map<String,String> getParameterMap(WebRequest request){
        Map<String,String> filterMap=new HashMap<String,String>();
        Iterator<String> iter = request.getParameterNames();
        while (iter.hasNext()) {
            String key = iter.next();
            String val = request.getParameter(key);
            filterMap.put(key, val);
        }
        return filterMap;
    }
}
