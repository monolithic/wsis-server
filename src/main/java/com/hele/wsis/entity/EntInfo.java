/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xuning
 *
 */
public class EntInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gid;
	private String nbxh;
	private String regNo;
	private String entName;
	
	private String addr;
	private String entType;
	private String industryCo;
	private Date estDate;
	private String country;
	private String addrDistrict;
	private String qyzt;
	private String lid;
	private String leveldesc;
	private String fileName;
	private String state;

    private String xydj;
	
	private Date regTime;
    private String infotype;
	
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLeveldesc() {
		return leveldesc;
	}
	public void setLeveldesc(String leveldesc) {
		this.leveldesc = leveldesc;
	}
	public String getNbxh() {
		return nbxh;
	}
	public void setNbxh(String nbxh) {
		this.nbxh = nbxh;
	}
	public String getQyzt() {
		return qyzt;
	}
	public void setQyzt(String qyzt) {
		this.qyzt = qyzt;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEntType() {
		return entType;
	}
	public void setEntType(String entType) {
		this.entType = entType;
	}
	public String getIndustryCo() {
		return industryCo;
	}
	public void setIndustryCo(String industryCo) {
		this.industryCo = industryCo;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddrDistrict() {
		return addrDistrict;
	}
	public void setAddrDistrict(String addrDistrict) {
		this.addrDistrict = addrDistrict;
	}
//	@Override
//	public String toString() {
//		return "EntInfo [gid=" + gid + ", nbxh=" + nbxh + ", regNo=" + regNo
//				+ ", entName=" + entName + ", addr=" + addr + ", entType="
//				+ entType + ", industryCo=" + industryCo + ", estDate="
//				+ estDate + ", country=" + country + ", addrDistrict="
//				+ addrDistrict + ", qyzt=" + qyzt + "]";
//	}
	
	public String getFileName(){
		return fileName;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

    public String getXydj() {
        return xydj;
    }

    public void setXydj(String xydj) {
        this.xydj = xydj;
    }

    public String getInfotype() {
        return infotype;
    }

    public void setInfotype(String infotype) {
        this.infotype = infotype;
    }
}


