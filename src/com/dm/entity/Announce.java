package com.dm.entity;
/**
 * 公告类
 * @author 帅冬阳
 *
 */
public class Announce {

	private int id;
	private String title;
	private String content;
	private String pic;
	private String time;
	private int announcer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Announce [id=" + id + ", title=" + title + ", content="
				+ content + ", pic=" + pic + ", time=" + time + ", announcer="
				+ announcer + "]";
	}
	public Announce() {
		super();
	}
	public Announce(int id, String title, String content, String pic,
			String time, int announcer) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pic = pic;
		this.time = time;
		this.announcer = announcer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAnnouncer() {
		return announcer;
	}
	public void setAnnouncer(int announcer) {
		this.announcer = announcer;
	}


}
