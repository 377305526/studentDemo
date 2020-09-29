package com.dm.service;

import java.util.ArrayList;

import com.dm.dao.BuildDao;
import com.dm.entity.Builds;

public class BuildsService {
	
	BuildDao bd=new BuildDao();
	
	
	/**
	 * 判断查询所有公寓信息是否成功！
	 * @return
	 */
	public ArrayList<Builds> getBuildsService()
	{    
		ArrayList<Builds> list=null;
		list=bd.queryAll();
		return list;
		
	}
	
	
	/**
	 * 判断查询单个公寓信息是否成功！
	 * @param id
	 * @return
	 */
	public Builds getOneBuildsService(int id)
	{
		
		return bd.queryById(id);
		
	}
	
	/**
	 * 判断增加公寓是否成功！
	 * @param params
	 * @return
	 */
	public boolean isAdd(Object...params)
	{
		
		return bd.addBuilds(params)>0;
		
	}
	
	
	
	
	
	/**
	 * 判断删除公寓是否成功！
	 * @param params
	 * @return
	 */
	public boolean isDel(int id)
	{
		
		return bd.delBuilds(id)>0;
		
	}
	
	
	
	/**
	 * 判断修改公寓是否成功！
	 * @param params
	 * @return
	 */
	public boolean isAlt(Object...params)
	{
		
		return bd.altBuilds(params)>0;
		
	}
	
	
	

}
