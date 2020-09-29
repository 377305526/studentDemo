package com.dm.entity;

/**
 * 宿舍实体类
 * 
 * @author 章学魁
 *
 */
public class Room {
	private int id;
	private int buildid;
	private String roomname;
	private int bednum;
	private int peoplenum;
	private String type;
	private String sextype;
	private String rent;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildid() {
		return buildid;
	}

	public void setBuildid(int buildid) {
		this.buildid = buildid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public int getBednum() {
		return bednum;
	}

	public void setBednum(int bednum) {
		this.bednum = bednum;
	}

	public int getPeoplenum() {
		return peoplenum;
	}

	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSextype() {
		return sextype;
	}

	public void setSextype(String sextype) {
		this.sextype = sextype;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Room() {

	}

	public Room(int id, int buildid, String roomname, int manager, int bednum, int peoplenum, String type,
			String sextype, String rent, String remark) {
		super();
		this.id = id;
		this.buildid = buildid;
		this.roomname = roomname;

		this.bednum = bednum;
		this.peoplenum = peoplenum;
		this.type = type;
		this.sextype = sextype;
		this.rent = rent;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", buildid=" + buildid + ", roomname=" + roomname + ", bednum=" + bednum
				+ ", peoplenum=" + peoplenum + ", type=" + type + ", sextype=" + sextype + ", rent=" + rent
				+ ", remark=" + remark + "]";
	}

}
