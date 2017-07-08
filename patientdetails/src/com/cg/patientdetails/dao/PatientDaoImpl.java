package com.cg.patientdetails.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.patientdetails.dbutil.DBUtil;
import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;
import com.cg.patientdetails.loggers.Mylogger;

public class PatientDaoImpl implements PatientDao  {
	
	Logger logger = Mylogger.getLoggerInstance();
	
	Connection con;
	public PatientDaoImpl()
	{
		con = DBUtil.getConnection();
		if(con!=null)
		{
			logger.info("obtain Connection");
		}
	}

	@Override
	public boolean insertDetails(PatientBean obj) throws PatientException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try
		{
			String sql = "INSERT INTO PATIENTDETAILS VALUES"
					+ "(patient_id_seq.NEXTVAL,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,obj.getpName());
			pstmt.setString(2,obj.getAddress());
			pstmt.setString(3,obj.getMobile());
			
			int row = pstmt.executeUpdate();
			if(row==0)
			{
				//logger.error();
				throw new PatientException("unable to insert");
			}
			else
			{
				logger.info("inserted record patient" +obj);
				flag = true;
				
			}
				
		
		}
		catch(SQLException e)
		{
			logger.error("Exception occured " +e.getMessage());
			throw new PatientException(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public PatientBean getRecord(int patientId) throws PatientException {
		// TODO Auto-generated method stub
		
		
		PatientBean bean = null;

		try{
		String sql = "SELECT * FROM PATIENTDETAILS WHERE ID = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,patientId);
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			bean = new PatientBean();
			bean.setpId(result.getInt(1));
			bean.setpName(result.getString(2));
			bean.setAddress(result.getString(3));
			bean.setMobile(result.getString(4));
			logger.info("fetch record" +bean);
		}
		else
			throw new PatientException("patient");
	}catch(SQLException e)
	{
		//throw new PatientException(e.getMessage());
		System.out.println(e.getMessage());
		
	}
	return bean;
	}

	@Override
	public ArrayList<PatientBean> getAllRecords() throws PatientException {
		// TODO Auto-generated method stub
		ArrayList<PatientBean> list = null; 
				
		try
		{
			String sql = "Select * from patientdetails";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			list = new ArrayList<PatientBean>();
			while(result.next())
			{
				PatientBean bean = new PatientBean();
				bean.setpId(result.getInt(1));
				bean.setpName(result.getString(2));
				bean.setAddress(result.getString(3));
				bean.setMobile(result.getString(4));
				list.add(bean);
			}
			if(list.size()==0)
			{
				throw new PatientException(" no data found");
			}
			
		}catch(PatientException e)
		{
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
