package com.hele.wsis.web;

import com.google.common.base.Strings;
import com.hele.commons.Constants;
import com.hele.commons.ServletUtils;
import com.hele.commons.shiro.MyFormAuthentication;
import com.hele.commons.shiro.StatelessToken;
import com.hele.wsis.entity.ResultObject;
import dm.jdbc.dbaccess.Const;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.mgt.eis.RandomSessionIdGenerator;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ning on 2014/6/30 0030.
 */
@Controller
public class HomeController {

    private static final String LOGIN_CACHE = "loginCache";
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private GuavaCacheManager guavaCacheManager;

    private Cache cache;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tologin(HttpServletRequest req, Model model){

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(HttpServletRequest request, @RequestParam(MyFormAuthentication.DEFAULT_USERNAME_PARAM) String userName, Model model){
        logger.info("you login failed");
        model.addAttribute(MyFormAuthentication.DEFAULT_USERNAME_PARAM, userName);
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }
    @RequestMapping(value = "/qr_login", method = RequestMethod.GET)
    public String qr_login(Model model){
        model.addAttribute("uuid", RandomStringUtils.randomAlphanumeric(14));
        model.addAttribute("qr_login_validate_url","/qr_login_validate");
        return "qr_login";
    }

    @RequestMapping( value = "qr_login_validate")
    @ResponseBody
    public ResultObject qr_login_validate(WebRequest request){
        //验证通过后，通知网页端登录成功
        Map<String,String> params = ServletUtils.getParameterMap(request);
        String username = params.get(Constants.PARAM_USERNAME);
        String digest = params.get(Constants.PARAM_DIGEST);
        params.remove(Constants.PARAM_DIGEST);
        String uuid = params.get("uuid");
        Map<String,String> params2 = new LinkedHashMap<>();
        params2.put("uuid",request.getParameter("uuid"));
        params2.put(Constants.PARAM_USERNAME,request.getParameter(Constants.PARAM_USERNAME));
        params2.put("authcode",request.getParameter("authcode"));
        StatelessToken token = new StatelessToken(username,params2,digest);

        cache  = guavaCacheManager.getCache(LOGIN_CACHE);
        cache.put(uuid,token);
        ResultObject ro = new ResultObject();
        ro.setStatus("00");
        return ro;
    }

    @RequestMapping( value = "qr_login_check",method = RequestMethod.GET)
    @ResponseBody
    public ResultObject qr_login_check(@RequestParam("uuid") String uuid){
        //长连接
        long inTime = new Date().getTime();
        ResultObject ro = new ResultObject();
        Boolean bool = true;
        while (bool) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //检测登录
            if(cache!=null&&cache.get(uuid,StatelessToken.class)!=null){
                bool = false;
                System.out.println("准备网页登录");
                //直接登录成功
                StatelessToken token = cache.get(uuid,StatelessToken.class);
                Subject subject = SecurityUtils.getSubject();
                try {
                    subject.login(token);
                } catch (AuthenticationException e){
                    e.printStackTrace();
                }
                cache.evict("uuid");
                System.out.println("网页登录成功");
                ro.setStatus("00");
                return ro;
            }else{
                if(new Date().getTime() - inTime > 5000){
                    bool = false;
                }
            }
        }
        ro.setStatus("01");
        return ro;
    }

    @RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
    public String home(HttpServletRequest request){
        logger.info("Welcome home!");
        //Subject subject = SecurityUtils.getSubject();
        //request.setAttribute("username", subject.getPrincipals());
        return "index";
    }
}
