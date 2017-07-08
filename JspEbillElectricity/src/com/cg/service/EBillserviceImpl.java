package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.BillBean;
import com.cg.beans.ConsumerBean;
import com.cg.dao.EBillDaoImpl;
import com.cg.dao.IEbill;
import com.cg.exception.EBillException;

public class EBillserviceImpl implements IEBillservice {
	
	IEbill dao;
	public void setdao(IEbill dao)
	{
		this.dao = dao;
	}
	public EBillserviceImpl() 
	{
		// TODO Auto-generated constructor stub
		dao = new EBillDaoImpl();
	}

	@Override
	public ArrayList<ConsumerBean> viewConsumerDetails() throws EBillException {
		// TODO Auto-generated method stub
		return dao.viewConsumerDetails();
	}
	@Override
	public ConsumerBean searchRecord(int consumer_num) throws EBillException {
		// TODO Auto-generated method stub
		return dao.searchRecord(consumer_num);
	}

	

	@Override
	public ArrayList<BillBean> viewBillDetails(int consumer_num) throws EBillException {
		// TODO Auto-generated method stub
		return dao.viewBillDetails(consumer_num);
	}

	@Override
	public boolean insertBillDetails(BillBean billobj) throws EBillException {
		// TODO Auto-generated method stub
		return dao.insertBillDetails(billobj);
	}
	

}
