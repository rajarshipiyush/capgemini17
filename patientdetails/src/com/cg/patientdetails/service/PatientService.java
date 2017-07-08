package com.cg.patientdetails.service;

import java.util.ArrayList;

import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;

public interface PatientService {
	
	public boolean insertDetails(PatientBean obj) throws PatientException;
	
	public PatientBean getRecord(int patientId) throws PatientException;
	
	public ArrayList<PatientBean>getAllRecords() throws PatientException;
	
	public boolean Validate(PatientBean bean); 

}
