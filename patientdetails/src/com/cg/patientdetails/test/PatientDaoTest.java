package com.cg.patientdetails.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.patientdetails.dao.PatientDao;
import com.cg.patientdetails.dao.PatientDaoImpl;
import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;
import com.cg.patientdetails.service.PatientServiceImpl;

public class PatientDaoTest {
	
	PatientServiceImpl service;
	PatientDao dao;
	
	@Before
	public void init()
	{
		service = new PatientServiceImpl();
		dao = new PatientDaoImpl();
		service.setDao(dao);

	}

	@Test
	public void testPatientDaoImpl() {
		//fail("Not yet implemented");
		
		
	}

	@Test
	public void testInsertDetails() {
		//fail("Not yet implemented");
		PatientBean bean = new PatientBean();
		bean.setpName("abc");
		bean.setAddress("mumbai");
		bean.setMobile("331113");
		try
		{
			assertEquals(true,service.insertDetails(bean));
			
		}catch(PatientException e)
		{
			e.getMessage();
		}
	}

	@Test
	public void testGetRecord() {
		//fail("Not yet implemented");
		try
		{
			assertNotNull(service.getRecord(1001));
		}
		catch(PatientException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void testGetAllRecords() {
		//fail("Not yet implemented");
		
		try {
			assertNotEquals(0,service.getAllRecords().size());
		} catch (PatientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
