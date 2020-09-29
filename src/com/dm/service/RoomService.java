package com.dm.service;

import java.util.ArrayList;
import java.util.List;

import com.dm.dao.RoomDao;
import com.dm.entity.Builds;
import com.dm.entity.Room;

public class RoomService {
	
	RoomDao rd=new RoomDao();
	
	/**
	 * 判断查询所有房间信息是否成功！
	 * @return
	 */
	public List getRoomService()
	{    
		List list=rd.queryAll();
		return list;
		
	}
	
	
	/**
	 * 判断查询单个房间信息是否成功！
	 * @param id
	 * @return
	 */
	public Room getOneRoomService(int id)
	{
		
		return rd.queryById(id);
		
	}
	
	/**
	 * 判断增加房间是否成功！
	 * @param params
	 * @return
	 */
	public boolean isAdd(Object...params)
	{
		
		return rd.addRoom(params)>0;
		
	}
	
	
	
	
	
	/**
	 * 判断删除房间是否成功！
	 * @param params
	 * @return
	 */
	public boolean isDel(int id)
	{
		
		return rd.delRoom(id)>0;
		
	}
	
	
	
	/**
	 * 判断修改房间是否成功！
	 * @param params
	 * @return
	 */
	public boolean isAlt(Object...params)
	{
		
		return rd.altRoom(params)>0;
		
	}
	

}
