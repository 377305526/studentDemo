package com.dm.entity;

/**
 * 权限类
 * 
 * @author 章学魁
 *
 */
public class Permission {

	private int id;
	private String name;
	private int buildmanage;
	private int roommanage;
	private int usermanage_now;
	private int usermanage_left;
	private int announcementmanage;
	private int approvalmanage_wait;
	private int sysmanage_permission;
	private int sysmanage_log;
	private int approvalmanage_history;
	private String remark;

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

	public int getBuildmanage() {
		return buildmanage;
	}

	public void setBuildmanage(int buildmanage) {
		this.buildmanage = buildmanage;
	}

	public int getRoommanage() {
		return roommanage;
	}

	public void setRoommanage(int roommanage) {
		this.roommanage = roommanage;
	}

	public int getUsermanage_now() {
		return usermanage_now;
	}

	public void setUsermanage_now(int usermanage_now) {
		this.usermanage_now = usermanage_now;
	}

	public int getUsermanage_left() {
		return usermanage_left;
	}

	public void setUsermanage_left(int usermanage_left) {
		this.usermanage_left = usermanage_left;
	}

	public int getAnnouncementmanage() {
		return announcementmanage;
	}

	public void setAnnouncementmanage(int announcementmanage) {
		this.announcementmanage = announcementmanage;
	}

	public int getApprovalmanage_wait() {
		return approvalmanage_wait;
	}

	public void setApprovalmanage_wait(int approvalmanage_wait) {
		this.approvalmanage_wait = approvalmanage_wait;
	}

	public int getSysmanage_permission() {
		return sysmanage_permission;
	}

	public void setSysmanage_permission(int sysmanage_permission) {
		this.sysmanage_permission = sysmanage_permission;
	}

	public int getSysmanage_log() {
		return sysmanage_log;
	}

	public void setSysmanage_log(int sysmanage_log) {
		this.sysmanage_log = sysmanage_log;
	}

	public int getApprovalmanage_history() {
		return approvalmanage_history;
	}

	public void setApprovalmanage_history(int approvalmanage_history) {
		this.approvalmanage_history = approvalmanage_history;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", buildmanage=" + buildmanage + ", roommanage=" + roommanage
				+ ", usermanage_now=" + usermanage_now + ", usermanage_left=" + usermanage_left
				+ ", announcementmanage=" + announcementmanage + ", approvalmanage_wait=" + approvalmanage_wait
				+ ", sysmanage_permission=" + sysmanage_permission + ", sysmanage_log=" + sysmanage_log
				+ ", approvalmanage_history=" + approvalmanage_history + ", remark=" + remark + "]";
	}

}
