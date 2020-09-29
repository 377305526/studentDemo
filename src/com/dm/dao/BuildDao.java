package com.dm.dao;

import java.util.ArrayList;

import com.dm.entity.Builds;
import com.dm.utils.DBUtil;

/**
 * 公寓DAO
 * 
 * @author 章学魁
 *
 */
public class BuildDao extends DBUtil<Builds> {

	/**
	 * 通过ID查询公寓信息
	 * 
	 * @param id
	 * @return
	 */
	public Builds queryById(Integer id) {
		String sql = "select * from builds where id=?";
		Builds build = getOneObject(sql, id);
		return build;
	}

	/**
	 * 查询公寓所以信息
	 * 
	 * @return
	 */
	public ArrayList<Builds> queryAll() {
		String sql = "select * from builds";
		ArrayList<Builds> list = (ArrayList<Builds>) this.getObjects(sql, null);
		return list;

	}

	/**
	 * 增加公寓信息
	 * 
	 * @param params
	 * @return
	 */
	public int addBuilds(Object... params) {
		String sql = "insert into Builds values(?,?,?,?)";
		return this.executeUpdate(sql, params);

	}

	/**
	 * 修改公寓信息
	 * 
	 * @param params
	 * @return
	 */
	public int altBuilds(Object... params) {
		String sql = "update builds set buildname=?,admin=?,remark=? where id=?";
		return this.executeUpdate(sql, params);

	}

	/**
	 * 删除公寓信息
	 * 
	 * @param id
	 * @return
	 */
	public int delBuilds(int id) {
		String sql = "delete from builds where id=?";
		return this.executeUpdate(sql, id);
	}

}
