package com.dm.entity;

/**
 * 公寓类
 * @author 章学魁
 *
 */
public class Builds {
	
	private int id;
	private String buildname;
	private int admin;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuildname() {
		return buildname;
	}
	public void setBuildname(String buildname) {
		this.buildname = buildname;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Builds()
	{
		
	}
	public Builds(int id, String buildname, int admin, String remark) {
		super();
		this.id = id;
		this.buildname = buildname;
		this.admin = admin;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "builds [id=" + id + ", buildname=" + buildname + ", admin="
				+ admin + ", remark=" + remark + "]";
	}
	
	
	
	
	
	

}
