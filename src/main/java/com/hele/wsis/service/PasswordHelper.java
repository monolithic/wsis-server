package com.hele.wsis.service;

import com.hele.wsis.entity.UserInfo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class PasswordHelper {

    public static final String default_salt = "a4215e599e2150ce52f8c76557d58751";
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(UserInfo user) {


//        user.setSalt(randomNumberGenerator.nextBytes().toHex());
//
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getGid()+default_salt),
                hashIterations).toHex();
//
        user.setPassword(newPassword);
    }
    public String getEncryptedPassword(Map<String,String> map){
        String newPassword = new SimpleHash(
                algorithmName,
                map.get("password"),
                ByteSource.Util.bytes(map.get("gid")+default_salt),
                hashIterations).toHex();
        return newPassword;
    }
}