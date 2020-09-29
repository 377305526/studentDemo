package com.dm.dao;

import java.util.List;

import com.dm.entity.Student;
import com.dm.utils.BaseUtils;
import com.dm.utils.DBUtil;

/**
 * 学生dao类
 * 
 * @author Administrator
 * 
 */
public class StudentDao extends DBUtil<Student> {
	/**
	 * 根据phone，pwd获取单个对象
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public Student getStu(String phone, String pwd) {
		String sql = "select * from student where phone=? and pwd=?";
		Student oneObject = getOneObject(sql, phone, pwd);
		return oneObject;
	}

	/**
	 * 通过手机号查询
	 * 
	 * @param phone
	 * @return
	 */
	public Student getStuByTel(String phone) {
		String sql = "select * from student where phone=?";
		Student oneObject = getOneObject(sql, phone);
		return oneObject;
	}

	/**
	 * 查询
	 */
	public List<Student> queryAllStu() {
		String sql = "select*from student";
		return this.getObjects(sql);

	}

	/**
	 * 根据Id查询
	 * 
	 * @return
	 */
	public Student queryById(int id) {
		String sql = "select*from student where id=?";
		return this.getOneObject(sql, id);

	}

	/**
	 * 根据入住状态查询
	 * 
	 * @param statu
	 * @return
	 */
	public List<Student> queryByStatu(String statu) {
		String sql = "select*from student where statu=?";
		return this.getObjects(sql, statu);

	}

	/**
	 * 删除
	 */
	public int deleteStu(int id) {
		String sql = "delete from student where id=?";
		return this.executeUpdate(sql, id);

	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public int addStu(Student stu) {

		String sql = "insert into student values(null,?,?,?,?,null,null,null,null,null,?,null,null,null,?,null,?,null)";
		int a = this.executeUpdate(sql, stu.getPwd(), stu.getUsername(), stu.getName(), stu.getIdcard(), stu.getPhone(),
				stu.getHometown(), stu.getRegistertime());
		return a;

	}

	/**
	 * 修改
	 * 
	 * @param stu
	 * @return
	 */
	public int updateStu(Student stu) {

		String sql = "update student set pwd=?,userName=?,name=?,idcard=?,class_=?,bedid=?,intime=?,outtime=?,email=?,phone=?,"
				+ "job=?,company=?,location=?,hometwon=?,flag=?,registertime=?,statu=? where id=?";
		return this.executeUpdate(sql, stu.getPwd(), stu.getUsername(), stu.getName(), stu.getIdcard(), stu.getClass_(),
				stu.getBedid(), stu.getIntime(), stu.getOuttime(), stu.getEmail(), stu.getPhone(), stu.getJob(),
				stu.getCompany(), stu.getLocation(), stu.getHometown(), stu.getFlag(), stu.getRegistertime(),
				stu.getStatu(), stu.getId());
	}

	/**
	 * 修改个人基本信息
	 * 
	 * @param stu
	 * @param phone
	 * @return
	 */
	public int updateBasicInfo(Student stu, String phone) {
		String sql = "update student set phone=?,email=?,location=?,company=?,job=? where phone=?";
		int executeUpdate = executeUpdate(sql, stu.getPhone(), stu.getEmail(), stu.getLocation(), stu.getCompany(),
				stu.getJob(), phone);
		return executeUpdate;
	}

	public boolean updateBed(Integer bedid, Integer classid, Integer id) {
		String sql = "update student set bedid=?,intime=?,statu='在宿',class_=? where id=?";
		int executeUpdate = executeUpdate(sql, bedid, new BaseUtils().getTime(), classid, id);
		if (executeUpdate == 1) {
			return true;
		}
		return false;
	}

}
