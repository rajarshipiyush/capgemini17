package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.BillBean;
import com.cg.beans.ConsumerBean;
import com.cg.exception.EBillException;

public interface IEBillservice {
	
public ArrayList<ConsumerBean> viewConsumerDetails() throws EBillException;
	
	public ConsumerBean searchRecord(int consumer_num) throws EBillException;
	
	public ArrayList<BillBean> viewBillDetails(int consumer_num) throws EBillException;
	
	public boolean insertBillDetails(BillBean billobj) throws EBillException;

}
