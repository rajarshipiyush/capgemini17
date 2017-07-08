package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.ComplaintBean;

public interface ICustomerService {
	
	public ComplaintBean addComplaint(ComplaintBean complaintBean);
	public ComplaintBean getComplaintStatus(int complaintId);
}
