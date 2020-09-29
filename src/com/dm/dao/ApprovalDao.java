package com.dm.dao;

import java.util.List;

import com.dm.entity.Approval;
import com.dm.utils.BaseUtils;
import com.dm.utils.DBUtil;

/**
 * 申请类
 * 
 * @author 章学魁
 *
 */
public class ApprovalDao extends DBUtil<Approval> {

	/**
	 * 提交申请
	 * 
	 * @param approval
	 * @return
	 */
	public int addApproval(Approval approval) {
		String sql = "insert into approval values(null,?,?,?,?,'等待审核',?,null,null)";
		int executeUpdate = executeUpdate(sql, approval.getType(), approval.getContent(), approval.getApplicant(),
				approval.getApprover(), approval.getTime());
		return executeUpdate;
	}

	/**
	 * 通过申请者id查询
	 * 
	 * @return
	 */
	public List<Approval> queryApproval(Integer id) {
		String sql = "select * from approval where applicant=?";
		List<Approval> approvals = getObjects(sql, id);
		return approvals;
	}

	/**
	 * 通过审批者id和审批状态查询查询
	 * 
	 * @return
	 */
	public List<Approval> queryApproval(Integer id, String state) {
		String sql = "select * from approval where approver=? and statu=?";
		List<Approval> approvals = getObjects(sql, id, state);
		return approvals;
	}

	/**
	 * 记录查询
	 */
	public List<Approval> queryApprovaHistory(Integer id, String state) {
		String sql = "select * from approval where approver=? and statu!=?";
		List<Approval> approvals = getObjects(sql, id, state);
		return approvals;
	}

	/**
	 * 通过id查询
	 * 
	 * @return
	 */
	public Approval queryApprovalById(Integer id) {
		String sql = "select * from approval where id=?";
		Approval approval = getOneObject(sql, id);
		return approval;
	}

	/**
	 * 修改申请状态
	 * 
	 * @param id
	 * @return
	 */
	public int updateApproval(String state, String remark, Integer id) {
		String sql = "update approval set statu=?,approvaltime=?,remark=? where id=?";
		int executeUpdate = executeUpdate(sql, state, new BaseUtils().getTime(), remark, id);
		return executeUpdate;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id) {
		String sql = "delete from approval where id=?";
		int executeUpdate = executeUpdate(sql, id);
		if (executeUpdate == 1) {
			return true;
		}
		return false;

	}

}
