/**
 * 
 */
package com.hele.wsis.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hele.commons.SessionVariable;
import com.hele.commons.shiro.StatelessToken;
import com.hele.wsis.entity.PersDetail;
import com.hele.wsis.entity.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


/**
 * @author Administrator
 * apache shiro 的公用认证和授权类
 */
public class ShiroDbRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private AccountManager accountManager;

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持StatelessToken类型的Token
        return token instanceof UsernamePasswordToken;
    }
//    private List<String> defaultPermission = Lists.newArrayList();
//
//    private List<String> defaultRole = Lists.newArrayList();
	
	/**
	 * 当用户进行访问链接时的授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {

        //List<> list = loginService.getUserGwList(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //TODO ADD ROLE AND PERMISSION
        SessionVariable model = principals.oneByType(SessionVariable.class);
        Assert.notNull(model, "找不到principals中的SessionVariable");
        String id = model.getUser().getGid();
        //加载用户资源信息
//        List<Resource> authorizationInfo = accountManager.getUserResources(id);
//        //List<Resource> resourcesList = mergeResourcesToParent(authorizationInfo, ResourceType.Security);
//
//        List<Map<String, Object>> userResources = accountManager.getUserResourceList(id);
//        List<Resource> resourcesList = convertToResource(userResources);


//        model.setAuthorizationInfo(authorizationInfo);
//        model.setMenusList(resourcesList);

        //添加用户拥有的permission
        //addPermissions(info,authorizationInfo);
        
//        List<String> roles = accountManager.findUserRoles(id);
//        addRoles(info,roles);
//        List<String> permissions = accountManager.findUserPermissions(id);
//        addPermissions(info,permissions);
//
//        List<Resource> resourceList = accountManager.getUserResources(id);
//        model.setAuthorizationInfo(resourceList);
        return info;
	}

    /**
	 * @Author: 卜繁晟
	 * @Created Date: 2014年6月18日 下午4:20:48
	 */
	private void addPermissions(SimpleAuthorizationInfo info,
			List<String> permissions) {
		Set<String> permissionSet = new HashSet<String>();
		for (String permission : permissions) {
			permissionSet.add(permission);
		}
		info.setStringPermissions(permissionSet);
	}

	/**
	 * @Author: xuning
	 * @Created Date: 2014年6月18日 下午4:02:49
	 */
	private void addRoles(SimpleAuthorizationInfo info, List<String> roles) {
		Set<String> roleIds = new HashSet<String>();
		for (String role : roles) {
			roleIds.add(role);
		}
		info.setRoles(roleIds);
	}

//	private List<Resource> convertToResource(List<Map<String, Object>> userResources) {
//        return convertToResource(userResources,null);
//    }
//
//    private List<Resource> convertToResource(List<Map<String, Object>> userResources,String parentId) {
//        if(userResources==null)
//            return null;
//        List<Resource> result = new ArrayList<Resource>();
//        for(Map<String, Object> menu:userResources){
//            String fid = (String)menu.get("fk_parent_id");
//            if((parentId==null&&fid==null)||(parentId!=null&&parentId.equals(fid))){
//                Resource resource = new Resource();
//                String id = (String)menu.get("id");
//                resource.setId(id);
//                resource.setIcon((String)menu.get("icon"));
//                resource.setLeaf((Boolean)menu.get("leaf"));
//                resource.setName((String)menu.get("name"));
//                resource.setPermission((String)menu.get("permission"));
//                resource.setRemark((String)menu.get("remark"));
//                resource.setSort((Long)menu.get("sort"));
//                resource.setType((String)menu.get("type"));
//                resource.setValue((String)menu.get("value"));
//                resource.setChildren(convertToResource(userResources,id));
//                result.add(resource);
//            }
//        }
//        return result;
//    }




    /**
     * 用户登录的身份验证方法
     *
     */
    @Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();
        UserInfo user = accountManager.getUserByUsername(username);

        if (user == null) {
            throw new UnknownAccountException();
        }
        PersDetail persDetail = accountManager.getPersDetailById(user.getGid());
//
//        if (user.getState().equals(State.Disable.getValue())) {
//            throw new DisabledAccountException("你的账户已被禁用,请联系管理员开通.");
//        }

        SessionVariable model = new SessionVariable(user);
        model.setPersDetail(persDetail);
        return new SimpleAuthenticationInfo(
        		model,
        		user.getPassword(),
        		ByteSource.Util.bytes(user.getGid()+PasswordHelper.default_salt),//salt=username+salt
        		getName());
    }

	/**
	  * 更新用户授权信息缓存.
	  */
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		//SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	@Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
	public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    /**
     * 设置默认permission
     *
     * @param defaultPermissionString permission 如果存在多个值，使用逗号","分割
     */
    public void setDefaultPermissionString(String defaultPermissionString) {
        String[] perms = StringUtils.split(defaultPermissionString, ",");
        //CollectionUtils.addAll(defaultPermission, perms);
    }

    /**
     * 设置默认role
     *
     * @param defaultRoleString role 如果存在多个值，使用逗号","分割
     */
    public void setDefaultRoleString(String defaultRoleString) {
        String[] roles = StringUtils.split(defaultRoleString,",");
        //CollectionUtils.addAll(defaultRole, roles);
    }

//    /**
//     * 设置默认permission
//     *
//     * @param defaultPermission permission
//     */
//    public void setDefaultPermission(List<String> defaultPermission) {
//        this.defaultPermission = defaultPermission;
//    }
//
//    /**
//     * 设置默认role
//     *
//     * @param defaultRole role
//     */
//    public void setDefaultRole(List<String> defaultRole) {
//        this.defaultRole = defaultRole;
//    }

//    /**
//     * 并合子类资源到父类中，返回一个新的资源集合
//     *
//     * @param list 资源集合
//     * @param ignoreType 不需要并合的资源类型
//     */
//    public List<Resource> mergeResourcesToParent(List<Resource> list,ResourceType ignoreType) {
//        List<Resource> result = new ArrayList<Resource>();
//
//        for (Resource r : list) {
//            if (r.getParent() == null && !StringUtils.equals(ignoreType.getValue(),r.getType())) {
//                mergeResourcesToParent(list,r,ignoreType);
//                result.add(r);
//            }
//        }
//
//        return result;
//    }

//    /**
//     * 遍历list中的数据,如果数据的父类与parent相等，将数据加入到parent的children中
//     *
//     * @param list 资源集合
//     * @param parent 父类对象
//     * @param ignoreType 不需要加入到parent的资源类型
//     */
//    private void mergeResourcesToParent(List<Resource> list, Resource parent,ResourceType ignoreType) {
//        if (!parent.getLeaf()) {
//            return ;
//        }
//
//        parent.setChildren(new ArrayList<Resource>());
//        parent.setLeaf(false);
//
//        for (Resource r: list) {
//            //这是一个递归过程，如果当前遍历的r资源的parentId等于parent父类对象的id，将会在次递归r对象。通过遍历list是否也存在r对象的子级。
//            if (!StringUtils.equals(r.getType(), ignoreType.getValue()) && StringUtils.equals(r.getParentId(),parent.getId()) ) {
//                r.setChildren(null);
//                mergeResourcesToParent(list,r,ignoreType);
//                parent.getChildren().add(r);
//                parent.setLeaf(true);
//            }
//
//        }
//    }


    /**
     * 通过正则表达式获取字符串集合的值
     *
     * @param obj 字符串集合
     * @param regex 表达式
     *
     * @return List
     */
    private List<String> getValue(List<String> obj,String regex){

        List<String> result = new ArrayList<String>();

//        if (CollectionUtils.isEmpty(obj)) {
//            return result;
//        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(StringUtils.join(obj, ","));

        while(matcher.find()){
            result.add(matcher.group(1));
        }

        return result;
    }
}
