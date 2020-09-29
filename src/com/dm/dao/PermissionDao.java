package com.dm.dao;

import java.util.List;

import com.dm.entity.Permission;
import com.dm.utils.DBUtil;

public class PermissionDao extends DBUtil<Permission> {

	public boolean addPerssion(Permission p) {
		String sql = "insert into permission values(null,?,?,?,?,?,?,?,?,?,?,?)";
		int executeUpdate = executeUpdate(sql, p.getName(), p.getBuildmanage(), p.getRoommanage(),
				p.getUsermanage_now(), p.getUsermanage_left(), p.getAnnouncementmanage(), p.getApprovalmanage_wait(),
				p.getSysmanage_permission(), p.getSysmanage_log(), p.getApprovalmanage_history(), p.getRemark());
		if (executeUpdate == 1) {
			return true;
		}
		return false;
	}

	public List<Permission> queryAll() {
		String sql = "select * from permission";
		List<Permission> objects = getObjects(sql);
		return objects;
	}

	public Permission queryById(Integer id) {
		String sql = "select * from permission where id=?";
		Permission permission = getOneObject(sql, id);
		return permission;
	}

	public boolean del(Integer id) {
		String sql = "delete from permission where id=?";
		int executeUpdate = executeUpdate(sql, id);
		if (executeUpdate == 1) {
			return true;
		}
		return false;
	}
}
