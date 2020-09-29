package com.dm.entity;

public class Msg {
	private int id;
	private String type;
	private String content;
	private int get;
	private String remark;
	private int flag;

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

	public int getGet() {
		return get;
	}

	public void setGet(int get) {
		this.get = get;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Msg [id=" + id + ", type=" + type + ", content=" + content + ", get=" + get + ", remark=" + remark
				+ ", flag=" + flag + "]";
	}

}
