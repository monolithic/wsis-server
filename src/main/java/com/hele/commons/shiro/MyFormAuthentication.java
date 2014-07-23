/**
 * 
 */
package com.hele.commons.shiro;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.hele.commons.SystemVariableUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Administrator
 * 
 */
@SuppressWarnings({ "unused" })
public class MyFormAuthentication extends FormAuthenticationFilter {

	private static Logger logger = LoggerFactory.getLogger(MyFormAuthentication.class);
	private long maxLoginAttempts = 10;
	public static ConcurrentHashMap<String, AtomicLong> accountLockMap = new ConcurrentHashMap<String, AtomicLong>();
	protected static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
    //在session中的存储验证码的key名称
    private String sessionCaptchaKeyAttribute = DEFAULT_CAPTCHA_PARAM;
	public String getCaptchaParam(){
		return captchaParam;
	}
	protected String getCaptcha(ServletRequest request){
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}
//	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response){
//		String username = getUsername(request);
//		String password = getPassword(request);
//		String captcha = getCaptcha(request);
//		boolean rememberMe = isRememberMe(request);
//		String host = getHost(request);
//		return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
//	}
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception{
//		AuthenticationToken token = createToken(request, response);
//		if(token == null){
//			String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken " + "must be created in order to execute a login attempt.";
//			throw new IllegalStateException(msg);
//		}
		AuthenticationToken token = this.createToken(request, response);
		Session session = SystemVariableUtils.createSessionIfNull();
		//获取当前验证码
		String currentCaptcha = (String) session.getAttribute(getSessionCaptchaKeyAttribute());
		//获取用户输入的验证码
		String submitCaptcha = getCaptcha(request);
		//如果验证码不匹配，登录失败
		if (StringUtils.isEmpty(submitCaptcha) || !StringUtils.equals(currentCaptcha,submitCaptcha.toLowerCase())) {
			//return onLoginFailure(token, new IncorrectCaptchaException("验证码不正确"), request, response);
		}
		if(checkIfAccountLocked(request)){
			return onLoginFailure(token, new ExcessiveAttemptsException(), request, response);
		}else{
			if(!doLogin(request, response, token)){
				resetAccountLock(getUsername(request));
//				// 验证完成如果正确，保存当前用户的token到数据库中，子项目通过传递来的用户信息，验证用户token，完成登录。
////				try{
////					String username = token.getPrincipal().toString();
////					ApplicationContext ctx = new ClassPathXmlApplicationContext("rmi_client_context.xml");
////					ILoginService loginService = (ILoginService) ctx.getBean("loginService");
////					loginService.login(username, String.valueOf(((UsernamePasswordToken)token).getPassword()));
////				}catch(Exception e){
////					e.printStackTrace();
////				}
				return false;
			}
			return true;
		}
		
//		return super.executeLogin(request, response);
	}
	
	/**
	 * 获取设置在session中的存储验证码的key名称
	 * 
	 * @return Sting
	 */
	public String getSessionCaptchaKeyAttribute() {
		return sessionCaptchaKeyAttribute;
	}
	
	private boolean checkIfAccountLocked(ServletRequest request){
		String username = getUsername(request);
		if(accountLockMap.get((String) username) != null){
			long remainLoginAttempts = accountLockMap.get((String) username).get();
			if(remainLoginAttempts <= 0){ return true; }
		}
		return false;
	}
	private boolean doLogin(ServletRequest request, ServletResponse response, AuthenticationToken token) throws Exception{
		try{
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token, subject, request, response);
		}catch(IncorrectCredentialsException e){
			decreaseAccountLoginAttempts(request);
			checkIfAccountLocked(request);
			return onLoginFailure(token, e, request, response);
		}catch(AuthenticationException e){
			return onLoginFailure(token, e, request, response);
		}
	}
	private void decreaseAccountLoginAttempts(ServletRequest request){
		AtomicLong initValue = new AtomicLong(maxLoginAttempts);
		AtomicLong remainLoginAttempts = accountLockMap.putIfAbsent(getUsername(request), new AtomicLong(maxLoginAttempts));
		if(remainLoginAttempts == null){
			remainLoginAttempts = initValue;
		}
		remainLoginAttempts.getAndDecrement();
		accountLockMap.put(getUsername(request), remainLoginAttempts);
	}
	private void resetAccountLock(String username){
		accountLockMap.put(username, new AtomicLong(maxLoginAttempts));
	}
	public void setMaxLoginAttempts(long maxLoginAttempts){
		this.maxLoginAttempts = maxLoginAttempts;
	}
	@Override
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae){
		// String className = ae.getClass().getName();
		request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
	}
}
