package com.cg.patientdetails.dao;

import java.util.ArrayList;

import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;

public interface PatientDao {
	
public boolean insertDetails(PatientBean obj) throws PatientException;
	
	public PatientBean getRecord(int patientId) throws PatientException;
	
	public ArrayList<PatientBean>getAllRecords() throws PatientException;


}
