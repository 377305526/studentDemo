package com.dm.service;

import com.dm.dao.BedsDao;
import com.dm.entity.Beds;

public class BedService {
	public boolean addBed(int bedNo, int roomId) {
		Beds beds = new Beds();
		beds.setBedno(bedNo);
		beds.setRoomid(roomId);
		boolean addBed = new BedsDao().addBed(beds);
		return addBed;
	}

}
