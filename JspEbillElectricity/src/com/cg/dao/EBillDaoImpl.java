package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.beans.BillBean;
import com.cg.beans.ConsumerBean;
import com.cg.dbconnect.DBConnect;
import com.cg.exception.EBillException;

public class EBillDaoImpl implements IEbill {
	
	Connection con;
	
	public EBillDaoImpl()
	{
		con = DBConnect.getConnection();
		
	}
	@Override
	public ArrayList<ConsumerBean> viewConsumerDetails() throws EBillException
	{
		// TODO Auto-generated method stub
		
		ArrayList<ConsumerBean> conslist = new ArrayList<ConsumerBean>();
		try
		{
			String sql = "SELECT * FROM CONSUMERS";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				ConsumerBean consbean = new ConsumerBean();
				consbean.setConsumer_num(result.getInt(1));
				consbean.setConsumer_name(result.getString(2));
				consbean.setAddress(result.getString(3));
				conslist.add(consbean);				
			}
			if(conslist.size()==0)
			{
				throw new EBillException("NO Records");
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(conslist);
		return conslist;
	}

	@Override
	public ConsumerBean searchRecord(int consumer_num) throws EBillException 
	{
		// TODO Auto-generated method stub
		ConsumerBean consbean = new ConsumerBean();
		try
		{
			String sql = "SELECT * FROM CONSUMERS WHERE CONSUMER_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,consumer_num);
			ResultSet result = pstmt.executeQuery();
			if(result.next())
			{
				consbean.setConsumer_num(result.getInt(1));
				consbean.setConsumer_name(result.getString(2));
				consbean.setAddress(result.getString(3));
			}
			else
			{
				throw new EBillException("No Such Consumer with "+consumer_num);
			}
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
			throw new EBillException("NO SUCH CONSUMER WITH " +consumer_num);
		}
		
		return consbean;
	}

	@Override
	public ArrayList<BillBean> viewBillDetails(int consumer_num) throws EBillException 
	{
		// TODO Auto-generated method stub
		ArrayList<BillBean> billist = new ArrayList<BillBean>();
		try
		{
			String sql = "SELECT BILL_NUM,CONSUMER_NUM,CUR_READING,UNITCONSUMED,NETAMOUNT FROM BILLDETAILS WHERE CONSUMER_NUM=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,consumer_num);
			ResultSet result = pstmt.executeQuery();
			while(result.next())
			{
				BillBean billbean = new BillBean();
				billbean.setBill_num(result.getInt(1));
				billbean.setConsumer_num(result.getInt(2));
				billbean.setCur_reading(result.getDouble(3));
				billbean.setUnit_consumed(result.getDouble(4));
				billbean.setNetamount(result.getDouble(5));
				billist.add(billbean);
			}
			if(billist.size()==0)
			{
				throw new EBillException("NO Bill Details for Consumer " +consumer_num);
			}
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
			throw new EBillException("NO BILL DETAILS FOR CONSUMER " +consumer_num);
		}
		return billist;
	}

	@Override
	public boolean insertBillDetails(BillBean billobj) throws EBillException 
	{
		// TODO Auto-generated method stub
		boolean flag = false;
		try
		{
			String sql = "INSERT INTO BILLDETAILS VALUES(SEQ_BILL_NUM.NEXTVAL,?,?,?,?,SYSDATE)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,billobj.getConsumer_num());
			pstmt.setDouble(2,billobj.getCur_reading());
			pstmt.setDouble(3,billobj.getUnit_consumed());
			pstmt.setDouble(4,billobj.getNetamount());
			int row = pstmt.executeUpdate();
			/*if(row==0)
			{
				return flag;
			}*/
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}

}
