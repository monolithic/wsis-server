package com.hele.wsis.entity;

import java.io.Serializable;

/*
 * 企业基础信息，来自信用接口
 */
public class EntBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nbxh;
	private String zch;
	private String qymc;
	private String fddbr;
	private String jyfw;
	private String qylx;
	private String clrq;
	private String zczb="0.0000";
	private String sjcze="0.0000";
	private String bz = "";
	private String zs = "";
	private String hzrq = "";
	private String djjg = "";
	private String zt = "";
	private String swgnsrdzdah = "";
	private String zzjgdm = "";
	private String swdnsrdzdah = "";
    private String gxdw = "";
    private String jyqsrq = "";
    private String jyjzrq = "";
	private String lrrq;

	public String getNbxh() {
		return nbxh;
	}
	public void setNbxh(String nbxh) {
		this.nbxh = nbxh;
	}
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch==null?"":zch;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc==null?"":qymc;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr==null?"":fddbr;
	}
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw==null?"":jyfw.trim();
	}
	public String getQylx() {
		return qylx;
	}
	public void setQylx(String qylx) {
		this.qylx = qylx==null?"":qylx;
	}
	public String getClrq() {
		return clrq;
	}
	public void setClrq(String clrq) {
		this.clrq = clrq==null?"":clrq;
	}
	public String getZczb() {
		return zczb;
	}
	public void setZczb(String zczb) {
		this.zczb = zczb==null?"0":zczb;
	}
	public String getSjcze() {
		return sjcze;
	}
	public void setSjcze(String sjcze) {
		this.sjcze = sjcze==null?"0":sjcze;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz==null?"":bz;
	}
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs==null?"":zs;
	}
	public String getHzrq() {
		return hzrq;
	}
	public void setHzrq(String hzrq) {
		this.hzrq = hzrq==null?"":hzrq;
	}
	public String getDjjg() {
		return djjg;
	}
	public void setDjjg(String djjg) {
		this.djjg = djjg==null?"":djjg;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt==null?"":zt;
	}
	public String getSwgnsrdzdah() {
		return swgnsrdzdah;
	}
	public void setSwgnsrdzdah(String swgnsrdzdah) {
		this.swgnsrdzdah = swgnsrdzdah==null?"":swgnsrdzdah;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm==null?"":zzjgdm;
	}
	public String getSwdnsrdzdah() {
		return swdnsrdzdah;
	}
	public void setSwdnsrdzdah(String swdnsrdzdah) {
		this.swdnsrdzdah = swdnsrdzdah==null?"":swdnsrdzdah;
	}
	public String getLrrq() {
		return lrrq;
	}
	public void setLrrq(String lrrq) {
		this.lrrq = lrrq;
	}

    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw==null?"":gxdw;
    }

    public String getJyqsrq() {
        return jyqsrq;
    }

    public void setJyqsrq(String jyqsrq) {
        this.jyqsrq = jyqsrq==null?"":jyqsrq;
    }

    public String getJyjzrq() {
        return jyjzrq;
    }

    public void setJyjzrq(String jyjzrq) {
        this.jyjzrq = jyjzrq==null?"":jyjzrq;
    }
}
