package com.cg.dao;

import java.util.ArrayList;

import com.cg.beans.ComplaintBean;

public interface ICustomerDAO {
	
	public ComplaintBean addComplaint(ComplaintBean complaintBean);
	public ComplaintBean getComplaintStatus(int complaintId);
}
