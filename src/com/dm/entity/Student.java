package com.dm.entity;
/**
 * 学生类
 * @author 帅冬阳
 *
 */
public class Student {
   private int  id;
   private String  pwd;
   private String  username;
   private String  name;
   private String  idcard;
   private int     class_;
   private int	   bedid;
   private String  intime;
   private String outtime;
   private String email;
   private String phone;
   private String job;
   private String company;
   private String location;
   private String hometown;
   private int flag;
   private String registertime;
   private String statu;
   
@Override
public String toString() {
	return "Student [id=" + id + ", pwd=" + pwd + ", username=" + username
			+ ", name=" + name + ", idcard=" + idcard + ", class_=" + class_
			+ ", bedid=" + bedid + ", intime=" + intime + ", outtime="
			+ outtime + ", email=" + email + ", phone=" + phone + ", job="
			+ job + ", company=" + company + ", location=" + location
			+ ", hometown=" + hometown + ", flag=" + flag + ", registertime="
			+ registertime + ", statu=" + statu + "]";
}
public Student() {
	super();
}
public Student(int id, String pwd, String username, String name, String idcard,
		int class_, int bedid, String intime, String outtime, String email,
		String phone, String job, String company, String location,
		String hometown, int flag, String registertime, String statu) {
	super();
	this.id = id;
	this.pwd = pwd;
	this.username = username;
	this.name = name;
	this.idcard = idcard;
	this.class_ = class_;
	this.bedid = bedid;
	this.intime = intime;
	this.outtime = outtime;
	this.email = email;
	this.phone = phone;
	this.job = job;
	this.company = company;
	this.location = location;
	this.hometown = hometown;
	this.flag = flag;
	this.registertime = registertime;
	this.statu = statu;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public int getClass_() {
	return class_;
}
public void setClass_(int class_) {
	this.class_ = class_;
}
public int getBedid() {
	return bedid;
}
public void setBedid(int bedid) {
	this.bedid = bedid;
}
public String getIntime() {
	return intime;
}
public void setIntime(String intime) {
	this.intime = intime;
}
public String getOuttime() {
	return outtime;
}
public void setOuttime(String outtime) {
	this.outtime = outtime;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getHometown() {
	return hometown;
}
public void setHometown(String hometown) {
	this.hometown = hometown;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getRegistertime() {
	return registertime;
}
public void setRegistertime(String registertime) {
	this.registertime = registertime;
}
public String getStatu() {
	return statu;
}
public void setStatu(String statu) {
	this.statu = statu;
}

}
