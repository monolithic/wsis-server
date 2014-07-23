package com.hele.commons;

import com.hele.wsis.entity.PersDetail;
import com.hele.wsis.entity.UserInfo;

import java.io.Serializable;


/**
 * 
 * 系统常用变量模型实体
 * 
 * @author maurice
 * 
 */
public class SessionVariable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	// 当前用户
	private UserInfo user;

    private PersDetail persDetail;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PersDetail getPersDetail() {
        return persDetail;
    }

    public void setPersDetail(PersDetail persDetail) {
        this.persDetail = persDetail;
    }
//	// 当前用户所在的组集合
//	private List<Group> groupsList;
//
//	// 当前用户的授权资源集合
//	private List<Resource> authorizationInfo;
//
//	// 当前用户的菜单集合
//	private List<Resource> menusList;

	public SessionVariable() {

	}

	public SessionVariable(UserInfo user) {
		this.user = user;
	}

    public SessionVariable(String username){
        this.username = username;
    }
//	public SessionVariable(User user, List<Group> groupsList,List<Resource> authorizationInfo, List<Resource> menusList) {
//		this.user = user;
//		this.groupsList = groupsList;
//		this.authorizationInfo = authorizationInfo;
//		this.menusList = menusList;
//	}

	/**
	 * 获取当前用户
	 * 
	 * @return {@link com.hele.wsis.entity.UserInfo}
	 */
	public UserInfo getUser() {
		return user;
	}

	/**
	 * 设置当前用户
	 * 
	 * @param user 当前用户
	 */
	public void setUser(UserInfo user) {
		this.user = user;
	}

	/**
	 * 获取当前用户所在的组集合
	 * 
	 * @return List
	 */
//	public List<Group> getGroupsList() {
//		return groupsList;
//	}

	/**
	 * 设置当前用户所在的组集合
	 * 
	 * @param groupsList 组集合
	 */
//	public void setGroupsList(List<Group> groupsList) {
//		this.groupsList = groupsList;
//	}

	/**
	 * 获取当前用户的所有授权资源集合
	 * 
	 * @return List
	 */
//	public List<Resource> getAuthorizationInfo() {
//		return authorizationInfo;
//	}

	/**
	 * 设置当前用户的所有授权资源集合
	 * 
	 * @param authorizationInfo 资源集合
	 */
//	public void setAuthorizationInfo(List<Resource> authorizationInfo) {
//		this.authorizationInfo = authorizationInfo;
//	}

	/**
	 * 获取当前用户拥有的菜单集合
	 * 
	 * @return List
	 */
//	public List<Resource> getMenusList() {
//		return menusList;
//	}


//	public void setMenusList(List<Resource> menusList) {
//		this.menusList = menusList;
//	}

    @Override
    public String toString() {
        if(this.getPersDetail()!=null){
            return this.getPersDetail().getRealName();
        }
        return username;
    }
}
