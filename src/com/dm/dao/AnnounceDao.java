package com.dm.dao;

import java.util.List;

import com.dm.entity.Announce;
import com.dm.utils.DBUtil;

/**
 * 公告dao类
 * 
 * @author Administrator
 *
 */
public class AnnounceDao extends DBUtil<Announce> {
	/**
	 * 查询所有公告
	 */
	public List<Announce> queryAllAnn() {
		String sql = "select*from announce";
		return this.getObjects(sql);

	}

	/**
	 * 根据id查询公告
	 * 
	 * @param id
	 * @return
	 */
	public Announce queryById(int id) {
		String sql = "select*from announce where id=?";
		return this.getOneObject(sql, id);

	}

	/**
	 * 添加公告
	 */
	public int addAnn(Announce ann) {
		String sql = "insert into announce values(null,?,?,?,?,?)";
		return this.executeUpdate(sql, ann.getTitle(), ann.getContent(), ann.getPic(), ann.getTime(),
				ann.getAnnouncer());

	}

	/**
	 * 删除公告
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAnn(int id) {
		String sql = "delete from announce where id=?";
		return this.executeUpdate(sql, id);

	}

	/**
	 * 修改公告
	 * 
	 * @param ann
	 * @return
	 */
	public int updateAnn(Announce ann) {
		String sql = "update announce set title=?,content=?,pic=?,time=?,announcer=? where id=?";
		return this.executeUpdate(sql, ann.getTitle(), ann.getContent(), ann.getPic(), ann.getTime(),
				ann.getAnnouncer(), ann.getId());

	}
}
