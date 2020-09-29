package com.dm.dao;

import java.util.List;

import com.dm.entity.Admin;
import com.dm.utils.DBUtil;

public class AdminDao extends DBUtil<Admin> {
	/**
	 * 获取单个对象
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public Admin getAdm(String phone, String pwd) {
		String sql = "select *from admin where phone=? and pwd=?";
		Admin oneObject = getOneObject(sql, phone, pwd);
		System.out.println(oneObject);
		return oneObject;

	}

	/**
	 * 查询所有
	 */
	public List<Admin> queryAllAdmin() {
		String sql = "select *from admin";
		return this.getObjects(sql);

	}

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	public Admin queryById(int id) {
		String sql = "select *from admin where id=?";
		return this.getOneObject(sql, id);

	}

	public int deleteAdm(int id) {
		String sql = "delete from admin where id=?";
		return this.executeUpdate(sql, id);

	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public int addAdm(Admin adm) {
		String sql = "insert into admin value(null,?,?,?,?)";
		int a = this.executeUpdate(sql, adm.getName(), adm.getPwd(), adm.getPhone(), adm.getPermission());
		return a;

	}

	/**
	 * 修改
	 * 
	 * @param adm
	 * @return
	 */
	public int update(String name, String tel, Integer id) {
		String sql = "update admin set name=?,phone=?where id=?";
		return this.executeUpdate(sql, name, tel, id);

	}

	public int updatePwd(String pwd, Integer id) {
		String sql = "update admin set pwd=?where id=?";
		return this.executeUpdate(sql, pwd, id);

	}

	public int updatePermission(int pid, Integer id) {
		String sql = "update admin set permission=? where id=?";
		return this.executeUpdate(sql, pid, id);

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAdmin(int id) {
		String sql = "delete from admin where id=?";
		return this.executeUpdate(sql, id);

	}

	public boolean add(Admin a) {
		String sql = "insert into admin values(null,?,'123456',?,?)";
		int executeUpdate = executeUpdate(sql, a.getName(), a.getPhone(), a.getPermission());
		if (executeUpdate == 1) {
			return true;
		}
		return false;
	}

}
