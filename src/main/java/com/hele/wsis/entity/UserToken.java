package com.hele.wsis.entity;

import java.util.Date;

/**
 * Created by ning on 2014/6/26 0026.
 */
public class UserToken {

    private String gid;
    private String token;
    private Date createTime;
    private Date duration;
    private Date lastUsedTime;
    private String status;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Date getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(Date lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
