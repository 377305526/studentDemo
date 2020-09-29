package com.dm.service;

import java.util.List;

import com.dm.dao.AdminDao;
import com.dm.entity.Admin;

public class AdminService {
	AdminDao adm = new AdminDao();

	/**
	 * 获取单个对象
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public boolean getAdm(String phone, String pwd) {
		Admin admin = adm.getAdm(phone, pwd);
		if (admin == null) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Admin> queryAllAdm() {
		return adm.queryAllAdmin();

	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Admin queryById(int id) {
		return adm.queryById(id);

	}

	/**
	 * 添加
	 * 
	 * @param admin
	 * @return
	 */
	public boolean addAdm(Admin admin) {
		if (adm.addAdm(admin) > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteAdmin(int id) {
		if (adm.deleteAdmin(id) > 0) {
			return true;
		} else {
			return false;
		}

	}

}
