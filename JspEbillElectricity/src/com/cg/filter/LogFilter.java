package com.cg.filter;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cg.beans.BillBean;
import com.cg.beans.ConsumerBean;
import com.cg.logger.MyLogger;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="LogFilter", urlPatterns="/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		HttpServletRequest req = (HttpServletRequest) request;
		ZonedDateTime indiantime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println("Log Date is " +indiantime);
		String qStr = req.getParameter("action");
		if("logfilter".equals(qStr))
		{
			HttpSession session = req.getSession(false);
			ArrayList<ConsumerBean> list = (ArrayList<ConsumerBean>) session.getAttribute("consumerlist");
			org.apache.log4j.Logger logger = MyLogger.getLoggerInstance();
			logger.info("consumer details are printed here");
			logger.info(list);
			
			ArrayList<BillBean> listbill = (ArrayList<BillBean>) session.getAttribute("billdetails");
			org.apache.log4j.Logger logbill = MyLogger.getLoggerInstance();
			logbill.info("bill details are printed here");
			logbill.info(logbill);
			
			ConsumerBean logconsumer = (ConsumerBean) session.getAttribute("consumerdetails");
			org.apache.log4j.Logger searchlog = MyLogger.getLoggerInstance();
			searchlog.info("search record printed here");
			searchlog.info(logconsumer);
			
			BillBean logbilinsert = (BillBean) session.getAttribute("billshow");
			org.apache.log4j.Logger insertlog = MyLogger.getLoggerInstance();
			insertlog.info("insert details are logged here");
			insertlog.info(logbilinsert);
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
