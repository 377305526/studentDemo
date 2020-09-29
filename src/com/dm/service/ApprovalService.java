package com.dm.service;

import com.dm.dao.ApprovalDao;
import com.dm.entity.Approval;

/**
 * 申请service层
 * 
 * @author 章学魁
 *
 */
public class ApprovalService {
	/**
	 * 提交申请
	 * 
	 * @return
	 */
	public boolean addApproval(Approval approval) {
		int row = new ApprovalDao().addApproval(approval);
		if (row == 1) {
			return true;
		}
		return false;
	}

	/**
	 * 审批申请
	 * 
	 * @param state
	 * @param id
	 * @return
	 */
	public boolean updateApproval(String state, String remark, Integer id) {
		int updateApproval = new ApprovalDao().updateApproval(state, remark, id);
		if (updateApproval == 1) {
			return true;
		} else {
			return false;
		}
	}
}
