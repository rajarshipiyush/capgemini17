package com.cg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.ComplaintBean;

@Repository
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ComplaintBean addComplaint(ComplaintBean complaintBean) {
		// TODO Auto-generated method stub
		entityManager.persist(complaintBean);
		entityManager.flush();
		return complaintBean;
	}

	@Override
	public ComplaintBean getComplaintStatus(int complaintId) {
		// TODO Auto-generated method stub
		ComplaintBean complaintStatus = entityManager.find(ComplaintBean.class,complaintId);
		return complaintStatus;
	}
}
