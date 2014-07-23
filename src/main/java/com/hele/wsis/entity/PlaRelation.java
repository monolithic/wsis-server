/**
 * 
 */
package com.hele.wsis.entity;

import java.io.Serializable;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-7-25下午3:38:52
 * 类说明：
 * 
 */
public class PlaRelation extends Relation implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private int buino;
	private String roomno;
	public int getBuino() {
		return buino;
	}
	public void setBuino(int buino) {
		this.buino = buino;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	
	
	
}
