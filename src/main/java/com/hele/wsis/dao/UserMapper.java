package com.hele.wsis.dao;

import com.hele.commons.mybatis.MybatisRepository;
import com.hele.wsis.entity.PersDetail;
import com.hele.wsis.entity.UserInfo;
import com.hele.wsis.entity.UserToken;

import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 14-1-27.
 */
@MybatisRepository
public interface UserMapper {
   // void insert(UserInfo entity);

    UserInfo getUserByUsername(String username);

    void saveToken(UserToken userToken);

    UserInfo getUserById(String username);

    UserToken getUserTokenById(String username);

    void deleteToken(UserToken userToken);

    void insertUserInfo(Map<String, String> gid);

    void insertPersDetail(Map<String, String> params);

    PersDetail getPersDetailById(String gid);


    /**
	 * @Author: 徐宁
	 * @Created Date: 2014年6月19日 下午2:53:08
	 */
	//List<UserInfo> findAll();
}
