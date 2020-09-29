package com.dm.dao;

import java.util.ArrayList;
import java.util.List;

import com.dm.entity.Builds;
import com.dm.entity.Room;
import com.dm.utils.DBUtil;

/**
 * 宿舍DAO
 * 
 * @author 章学魁
 *
 */

public class RoomDao extends DBUtil<Room> {
	/**
	 * 通过ID获取房间信息
	 * 
	 * @param id
	 * @return
	 */
	public Room queryById(Integer id) {
		String sql = "select * from room where id=?";
		Room room = getOneObject(sql, id);
		return room;
	}

	public Room queryByBuildAndName(Integer id, String name) {
		String sql = "select * from room where buildid=? and roomname=?";
		Room room = getOneObject(sql, id, name);
		return room;

	}

	public List<Room> queryByBuildIdAndType(Integer id, String type, String sex) {
		String sql = "select * from room where buildid=? and type=? and sextype=?";
		List<Room> list = getObjects(sql, id, type, sex);
		return list;
	}

	/**
	 * 查询房间所有信息
	 * 
	 * @return
	 */
	public List queryAll() {
		String sql = "select * from room";
		List<Room> rooms = getObjects(sql, null);
		return rooms;
	}

	/**
	 * 修改房间信息
	 * 
	 * @param params
	 * @return
	 */
	public int altRoom(Object... params) {
		String sql = "update from room set buildid=?,roomname=?,bednum=?,,type=?,rent=?,remark=?where id=?";
		return this.executeUpdate(sql, params);

	}

	/**
	 * 增加房间信息
	 * 
	 * @param params
	 * @return
	 */
	public int addRoom(Object... params) {
		String sql = "insert into room values(?,?,?,?,?,?,?,?,?)";
		return executeUpdate(sql, params);

	}

	/**
	 * 删除房间信息
	 * 
	 * @param id
	 * @return
	 */
	public int delRoom(int id) {
		String sql = "delete from room where id=?";
		return executeUpdate(sql, id);
	}

}
