/**
 * 
 */
package com.hele.wsis.service;

import com.hele.wsis.dao.UserMapper;
import com.hele.wsis.entity.PersDetail;
import com.hele.wsis.entity.UserInfo;
import com.hele.wsis.entity.UserToken;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


/**
 * 安全相关实体的管理类,包括用户和权限组.
 * @author Administrator
 *
 */
@Service
@Transactional(readOnly=true)	////默认将类中的所有public函数纳入事务管理.
public class AccountManager {

	//用户数据访问
	@Autowired
	private UserMapper userMapper;
	
	//资源数据访问
//	@Autowired
//	private ResourceMapper resourceMapper;
//
//	//组数据访问
//	@Autowired
//	private GroupMapper groupMapper;
//
//	/**
//	 * @Author: 徐宁
//	 * @Created Date: 2014年6月13日 上午10:58:18
//	 */
	public UserInfo getUserByUsername(String username) throws DataAccessException {
		return userMapper.getUserByUsername(username);
	}
    @Transactional(readOnly=false)
    public void saveToken(UserToken userToken) {
        userMapper.deleteToken(userToken);
        userMapper.saveToken(userToken);
    }

    public UserInfo getUserById(String username) {

        return userMapper.getUserById(username);
    }

    public UserToken getUserToken(String username) {
        return userMapper.getUserTokenById(username);
    }

    @Transactional(readOnly=false)
    public void saveUser(Map<String, String> params) throws DataAccessException{
        String gid = genGid();
        params.put("gid",gid);
        String password = new PasswordHelper().getEncryptedPassword(params);
        params.put("password",password);
        params.put("status","0");
        params.put("usertype","3");
        userMapper.insertUserInfo(params);
        userMapper.insertPersDetail(params);
    }

    private String genGid(){
        return "wsis"+RandomStringUtils.randomNumeric(8);
    }

    public PersDetail getPersDetailById(String gid) {
        return userMapper.getPersDetailById(gid);
    }

//	/**
//	 * @Author: 徐宁
//	 * @Created Date: 2014年6月13日 上午11:21:12
//	 */
//	public List<Resource> getUserResources(String id) {
//		return resourceMapper.getUserResources(id);
//	}
//
//
//	/**
//	 * @Author: 卜繁晟
//	 * @Created Date: 2014年6月18日 下午4:07:14
//	 */
//	public List<String> findUserRoles(String id) {
//		return groupMapper.findUserRoles(id);
//	}
//
//	/**
//	 * @Author: 卜繁晟
//	 * @Created Date: 2014年6月18日 下午4:17:24
//	 */
//	public List<String> findUserPermissions(String id) {
//		return resourceMapper.findUserPermissions(id);
//	}
	
}
