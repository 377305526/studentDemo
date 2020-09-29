package com.dm.dao;

import java.util.List;

import com.dm.entity.Beds;
import com.dm.utils.DBUtil;

/**
 * 床位的dao类
 * 
 * @author 章学魁
 *
 */
public class BedsDao extends DBUtil<Beds> {

	/**
	 * 通过ID查询对应的床位信息
	 * 
	 * @param id
	 * @return
	 */
	public Beds queryById(Integer id) {
		String sql = "select * from beds where id=?";
		Beds bed = getOneObject(sql, id);
		return bed;
	}

	public boolean updateState(int id) {
		String sql = "update beds set statu=1 where id =?";
		int executeUpdate = executeUpdate(sql, id);
		if (executeUpdate == 1) {
			return true;
		}
		return false;

	}

	/**
	 * 新增床位
	 * 
	 * @param bed
	 * @return
	 */
	public boolean addBed(Beds bed) {
		String sql = "insert into beds values(null,?,?,0)";
		int executeUpdate = executeUpdate(sql, bed.getBedno(), bed.getRoomid());
		if (executeUpdate == 1) {
			return true;
		}
		return false;

	}

	/**
	 * 未入住床位
	 * 
	 * @param id
	 * @return
	 */
	public List<Beds> queryByRoomId(Integer id) {
		String sql = "select * from beds where roomid=? and statu=0";
		List<Beds> beds = getObjects(sql, id);
		return beds;
	}

}
