package com.hele.wsis.service;

import com.hele.commons.SessionVariable;
import com.hele.commons.codec.HmacSHA256Utils;
import com.hele.commons.shiro.StatelessToken;
import com.hele.wsis.entity.PersDetail;
import com.hele.wsis.entity.UserInfo;
import com.hele.wsis.entity.UserToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ning on 2014/7/2 0002.
 */
public class StatelessRealm extends AuthorizingRealm {

    @Autowired
    private AccountManager accountManager;

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持StatelessToken类型的Token
        return token instanceof StatelessToken;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //根据用户名查找角色，请根据需求实现
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //TODO ADD ROLE AND PERMISSION
        SessionVariable model = principals.oneByType(SessionVariable.class);

        authorizationInfo.addRole("admin");
        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        StatelessToken statelessToken = (StatelessToken) token;
        String username = statelessToken.getUsername();
        String key = getKey(username);//根据用户名获取密钥（和客户端的一样）
        //在服务器端生成客户端参数消息摘要
        String serverDigest = HmacSHA256Utils.digest(key, statelessToken.getParams());
        System.out.println(statelessToken.getClientDigest());
        System.out.println(serverDigest);
        SessionVariable model = new SessionVariable(username);
        UserInfo userInfo = accountManager.getUserById(username);
        model.setUser(userInfo);
        PersDetail persDetail = accountManager.getPersDetailById(userInfo.getGid());
        model.setPersDetail(persDetail);
        //然后进行客户端消息摘要和服务器端消息摘要的匹配
        return new SimpleAuthenticationInfo(
                model,
                serverDigest,
                getName());
    }

    private String getKey(String username) {//得到密钥，此处硬编码一个

        UserToken userToken = accountManager.getUserToken(username);
        return userToken.getToken();
        //if("admin".equals(username)) {
        //    return "dadadswdewq2ewdwqdwadsadasd";
        //}
        //return null;
    }
}
