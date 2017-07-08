package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.ComplaintBean;
import com.cg.dao.ICustomerDAO;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerDAO dao;

	@Override
	public ComplaintBean addComplaint(ComplaintBean complaintBean) {
		// TODO Auto-generated method stub
		return dao.addComplaint(complaintBean);
	}

	@Override
	public ComplaintBean getComplaintStatus(int complaintId) {
		// TODO Auto-generated method stub
		return dao.getComplaintStatus(complaintId);
	}
}
