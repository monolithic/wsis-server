package com.hele.wsis.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-18
 * Time: 上午10:18
 * To change this template use File | Settings | File Templates.
 */
public class PermDetail {

    private String sid;
    private String pid;
    private String status;
    private String permDesc;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }
}
