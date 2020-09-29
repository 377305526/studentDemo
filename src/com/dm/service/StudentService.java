package com.dm.service;

import java.util.List;

import com.dm.dao.StudentDao;
import com.dm.entity.Student;

/**
 * 学生Service类
 * 
 * @author Administrator
 *
 */
public class StudentService {
	StudentDao sd = new StudentDao();

	/**
	 * 获取单个对象
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public boolean getStu(String phone, String pwd) {
		Student stu = new StudentDao().getStu(phone, pwd);
		if (stu == null) {
			return false;
		}
		return true;
	}

	/**
	 * 查询所有学生
	 * 
	 * @return
	 */
	public List<Student> queryAllStu() {
		return sd.queryAllStu();

	}

	/**
	 * 根据id查询
	 */
	public Student queryById(int id) {
		return sd.queryById(id);

	}

	/**
	 * 根据入住状态查询
	 * 
	 * @param statu
	 * @return
	 */
	public List<Student> queryByStatu(String statu) {

		return sd.queryByStatu(statu);

	}

	/**
	 * 删除学生
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteStu(int id) {
		if (sd.deleteStu(id) > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 添加学生
	 * 
	 * @param stu
	 * @return
	 */
	public boolean addStu(Student stu) {
		if (sd.addStu(stu) > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 修改学生
	 * 
	 * @param stu
	 * @return
	 */
	public boolean updateStu(Student stu) {
		if (sd.updateStu(stu) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 *修改个人基本信息 
	 */
	public boolean updateBasicInfo(String phone, String email, String location, String company, String job,String oldphone) {
		Student s = new Student();
		s.setPhone(phone);
		s.setEmail(email);
		s.setLocation(location);
		s.setCompany(company);
		s.setJob(job);
		int row = new StudentDao().updateBasicInfo(s, oldphone);
		if (row == 1) {
			return true;
		}
		return false;
	}

}
