package com.dm.entity;

/**
 * 超级管理员
 * @author 章学魁
 *
 */
public class Administrator {
	
	private int id;
	private String name;
	private String pwd;
	private String permission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public Administrator()
	{
		
	}
	public Administrator(int id, String name, String pwd, String permission) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", permission=" + permission + "]";
	}
	
	
	
	
	

}
