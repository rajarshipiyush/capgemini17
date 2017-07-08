package com.cg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.beans.BillBean;
import com.cg.beans.ConsumerBean;
import com.cg.exception.EBillException;
import com.cg.service.EBillserviceImpl;
import com.cg.service.IEBillservice;

/**
 * Servlet implementation class EBillController
 */
@WebServlet("/EBillController")
public class EBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEBillservice service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EBillController()
    {
        service = new EBillserviceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String qStr = request.getParameter("action");
		if("consumerlist".equals(qStr))
		{
			try
			{
				ArrayList<ConsumerBean> conslist = service.viewConsumerDetails();
				session.setAttribute("consumerlist", conslist);
				RequestDispatcher dispatch = request.getRequestDispatcher("consumerlist.jsp?action=logfilter");
				dispatch.forward(request, response);
			}
			catch(EBillException e)
			{
				e.printStackTrace();				
			}
			
		}
		if("consumerSearch".equals(qStr))
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("searchconsumer.jsp");
			dispatch.forward(request, response);
		}
		if("billdetails".equals(qStr))
		{
			int consumer_num = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("cons_num",consumer_num);
			
			try
			{
				//int consumer_num = Integer.parseInt(request.getParameter("id"));
				ArrayList<BillBean> billlist = service.viewBillDetails(consumer_num);
				session.setAttribute("billdetails", billlist);
				
				String cons_name = (String) request.getParameter("name");
				session.setAttribute("consumername",cons_name);
				RequestDispatcher dispatch = request.getRequestDispatcher("billdetails.jsp?action=logfilter");
				dispatch.forward(request, response);
				
			}
			catch(EBillException e)
			{
				//e.printStackTrace();
				session.setAttribute("Exception",e.getMessage());
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
				
			}
		}				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String qStr = request.getParameter("action");
		/*if("consumerlist".equals(qStr))
		{
			try
			{
				ArrayList<ConsumerBean> conslist = service.viewConsumerDetails();
				session.setAttribute("consumerlist", conslist);
				RequestDispatcher dispatch = request.getRequestDispatcher("consumerlist.jsp");
				dispatch.forward(request, response);
			}
			catch(EBillException e)
			{
				e.printStackTrace();
			}
		}*/
		if("search".equals(qStr))
		{
			try
			{
				int consumer_num = Integer.parseInt(request.getParameter("cons_number"));
				ConsumerBean consbean = new ConsumerBean();
				consbean.setConsumer_num(consumer_num);
				ConsumerBean conbean = service.searchRecord(consumer_num);
				session.setAttribute("consumerdetails",conbean);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("consumerdetails.jsp?action=logfilter");
				dispatch.forward(request, response);
				//session.setAttribute("consumerdetails",consumer_num);
			}
			catch(EBillException e)
			{
				//e.printStackTrace();
				session.setAttribute("Exception",e.getMessage());
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
			}
			
		}
		if("calculatebill".equals(qStr))
		{
			boolean flag = false;
			int fix_charge = 100;
			try
			{
				int consumer_num = Integer.parseInt(request.getParameter("id"));
				double crnt_read_met = Double.parseDouble(request.getParameter("cmred"));
				double lst_read_met = Double.parseDouble(request.getParameter("lmred"));
				
				double netmetred = crnt_read_met - lst_read_met;
				double net_amount = netmetred*1.15 + fix_charge;
				
				BillBean billobj = new BillBean();
				
				billobj.setConsumer_num(consumer_num);
				billobj.setCur_reading(crnt_read_met);
				billobj.setUnit_consumed(netmetred);
				billobj.setNetamount(net_amount);
				
				flag = service.insertBillDetails(billobj);
				session.setAttribute("billshow",billobj);
				//RequestDispatcher dispatch = request.getRequestDispatcher("calculatebill.jsp");
				//dispatch.forward(request, response);
				RequestDispatcher dispatch = request.getRequestDispatcher("billsuccess.jsp?action=logfilter");
				dispatch.forward(request, response);
				
				
			}
			catch(EBillException e)
			{
				e.printStackTrace();
			}
		}
	}
}
