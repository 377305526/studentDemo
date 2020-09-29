package com.dm.entity;

/**
 * 床位类
 * @author 章学魁
 *
 */
public class Beds {
	
	private int id;
	private int bedno;
	private int roomid;
	private int studentid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBedno() {
		return bedno;
	}
	public void setBedno(int bedno) {
		this.bedno = bedno;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public Beds()
	{
		
	}
	public Beds(int id, int bedno, int roomid, int studentid) {
		super();
		this.id = id;
		this.bedno = bedno;
		this.roomid = roomid;
		this.studentid = studentid;
	}
	@Override
	public String toString() {
		return "beds [id=" + id + ", bedno=" + bedno + ", roomid=" + roomid
				+ ", studentid=" + studentid + "]";
	}
	
	
	
	
	

}
