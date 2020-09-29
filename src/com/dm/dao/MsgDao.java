package com.dm.dao;

import java.util.List;

import com.dm.entity.Msg;
import com.dm.utils.DBUtil;

public class MsgDao extends DBUtil<Msg> {
	public boolean add(String type, String content, int get, String remark) {
		String sql = "insert into msg values(null,?,?,?,?,0)";
		int executeUpdate = executeUpdate(sql, type, content, get, remark);
		if (executeUpdate == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean read(int id) {
		String sql = "update msg set flag=1 where id=?";
		int executeUpdate = executeUpdate(sql, id);
		if (executeUpdate == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<Msg> queryByGet(int id) {
		String sql = "select * from msg where get=? and flag=0";
		List<Msg> objects = getObjects(sql, id);
		return objects;
	}
}
