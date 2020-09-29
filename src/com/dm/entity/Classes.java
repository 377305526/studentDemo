package com.dm.entity;

/**
 * 班级类
 * @author 章学魁
 *
 */
public class Classes {
	
	private int id;
	private String classname;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Classes()
	{
		
	}
	public Classes(int id, String classname, String remark) {
		super();
		this.id = id;
		this.classname = classname;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "CkClass [id=" + id + ", classname=" + classname + ", remark="
				+ remark + "]";
	}
	
	
	
	

}
