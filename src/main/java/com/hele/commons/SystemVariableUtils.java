/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.hele.commons;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波子公司
 * @Project: 宁波市国税-外维系统
 * @Module ID: 
 * @Description: 
 * @JDK version used: JDK1.6
 * @Author: 卜繁晟
 * @Email: 5545795@qq.com | bufsh@css.com.cn
 * @Created Date: 2014年6月5日 下午4:49:53
 */
public class SystemVariableUtils {

	/**
	 * @Author: 徐宁
	 * @Created Date: 2014年6月5日 下午4:50:00
	 */
	public static boolean isAuthenticated() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
	
	/**
	 * 获取当前系统常用Session变量实体
	 * @Author: 徐宁
	 * @Created Date: 2014年6月5日 下午4:50:00
	 * @return {@link SessionVariable}
	 */
	public static SessionVariable getSessionVariable() {
		
		Subject subject = SecurityUtils.getSubject();
		
		if (subject != null && subject.getPrincipals() != null) {
			return subject.getPrincipals().oneByType(SessionVariable.class);
		}
		
		return null;
	}

	/**
	 * @Author: 徐宁
	 * @Created Date: 2014年6月13日 上午10:12:37
	 */
	public static Session createSessionIfNull() {
		Session session = getSession();

		if (session == null) {
			session = getSession(true);
		}

		return session;
	}

	/**
	 * @Author: 徐宁
	 * @Created Date: 2014年6月13日 上午10:13:16
	 */
	public static Session getSession() {
		return getSession(false);
	}
	
	/**
	 *
	 * 获取shiro的session
	 *
	 * @param create true表示如果不存在，就创建，否则用现有的
	 *
	 * @return {@link org.apache.shiro.session.Session}
	 */
	public static Session getSession(boolean create) {
		return SecurityUtils.getSubject().getSession(create);
	}

}
