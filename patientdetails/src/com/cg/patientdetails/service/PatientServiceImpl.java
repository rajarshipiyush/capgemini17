package com.cg.patientdetails.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.patientdetails.dao.PatientDao;
import com.cg.patientdetails.dao.PatientDaoImpl;
import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;

public class PatientServiceImpl implements PatientService{
	
	PatientDao dao; //= new PatientDaoImpl();
	
	public void setDao(PatientDao dao)
	{
		this.dao = dao;
	}
	public PatientServiceImpl()
	{
		dao = new PatientDaoImpl();
	}

	@Override
	public boolean insertDetails(PatientBean obj) throws PatientException {
		// TODO Auto-generated method stub
		//return dao.getRecord(patientId);
		return dao.insertDetails(obj);
	}

	@Override
	public PatientBean getRecord(int patientId) throws PatientException {
		// TODO Auto-generated method stub
		return dao.getRecord(patientId);
	}

	@Override
	public ArrayList<PatientBean> getAllRecords() throws PatientException {
		// TODO Auto-generated method stub
		return dao.getAllRecords();
	}
	@Override
	public boolean Validate(PatientBean bean) {
		// TODO Auto-generated method stub
		String name = "[A-Z]{1}[a-zA-Z]+";
		
		String addr = "[A-Z]{1}[a-zA-Z]+";
		String number ="[7-9]{1}[0-9]{9}";
		if(!Pattern.matches(name, bean.getpName()))
			return false;
		
		if(!Pattern.matches(addr, bean.getAddress()))
			return false;
		if(!Pattern.matches(number, bean.getMobile()))
			return false;
		return true;
		//return false;
	}

}
