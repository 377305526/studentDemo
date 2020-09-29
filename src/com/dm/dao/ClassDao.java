package com.dm.dao;

import java.util.List;

import com.dm.entity.Classes;
import com.dm.utils.DBUtil;

/**
 * 
 * @author 章学魁
 *
 */
public class ClassDao extends DBUtil<Classes> {
	/**
	 * 通过ID查询
	 * 
	 * @return
	 */
	public Classes queryById(Integer id) {
		String sql = "select * from class where id=?";
		Classes c = getOneObject(sql, id);
		return c;

	}

	public List<Classes> queryAll() {
		String sql = "select * from class";
		List<Classes> classes = getObjects(sql);
		return classes;
	}
}
