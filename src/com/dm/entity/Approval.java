package com.dm.entity;

/**
 * 审批类
 * 
 * @author 章学魁
 *
 */
public class Approval {

	private int id;
	private String type;
	private String content;
	private int applicant;
	private int approver;
	private String statu;
	private String time;
	private String approvalTime;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Approval() {

	}

	public int getApplicant() {
		return applicant;
	}

	public void setApplicant(int applicant) {
		this.applicant = applicant;
	}

	public int getApprover() {
		return approver;
	}

	public void setApprover(int approver) {
		this.approver = approver;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Approval(int id, String type, String content, int applicant, int approver, String statu) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.applicant = applicant;
		this.approver = approver;
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Approval [id=" + id + ", type=" + type + ", content=" + content + ", applicant=" + applicant
				+ ", approver=" + approver + ", statu=" + statu + ", time=" + time + ", approvalTime=" + approvalTime
				+ ", remark=" + remark + "]";
	}

}
