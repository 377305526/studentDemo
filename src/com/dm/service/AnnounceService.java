package com.dm.service;

import java.util.List;

import com.dm.dao.AnnounceDao;
import com.dm.entity.Announce;

/**
 * 公告service类
 * @author Administrator
 *
 */
public class AnnounceService {
	AnnounceDao ad =new AnnounceDao();
	public List<Announce> queryAllAnn(){
		return ad.queryAllAnn();
		
	}
	public Announce queryById(int id){
		return ad.queryById(id);
	}
	public boolean addAnn(Announce ann){
		if(ad.addAnn(ann)>0){
			return true;
		}else{
			return false;
		}

	}
	public boolean deleteAnn(int id){
		if(ad.deleteAnn(id)>0){
			return true;
		}else{
			return false;
		}

		
	}
	public boolean updateAnn(Announce ann){
		if(ad.updateAnn(ann)>0){
			return true;
		}else{
			return false;
		}

	
			
	}
}
