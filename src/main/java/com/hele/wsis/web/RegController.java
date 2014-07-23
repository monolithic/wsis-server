package com.hele.wsis.web;

import com.hele.commons.ServletUtils;
import com.hele.wsis.entity.ResultObject;
import com.hele.wsis.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ning on 2014/6/29 0029.
 */
@Controller
public class RegController {

    @Autowired
    private AccountManager accountManager;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String toreg(HttpServletRequest req, Model model){

        return "reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    public ResultObject register(WebRequest req, Model model){
        Map<String,String> params = ServletUtils.getParameterMap(req);
        accountManager.saveUser(params);
        ResultObject ro = new ResultObject();
        ro.setStatus("00");
        return ro;
    }
}
