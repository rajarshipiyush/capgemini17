package com.cg.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.beans.ComplaintBean;
import com.cg.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	@Autowired
	ComplaintBean complaintBean;
	
	@RequestMapping(value="/newComplaint")
	public String raiseComplaintPage(Model model)
	{
		ArrayList<String> complaintlist = new ArrayList<String>();
		complaintlist.add("Internet Banking");
		complaintlist.add("General Banking");
		complaintlist.add("Others");
		model.addAttribute("complaintlist",complaintlist);
		model.addAttribute("complaintRaise",complaintBean);
		return "raiseComplaintPage";
	}
	
	@RequestMapping(value="/insertComplaint")
	public String raiseComplaint(Model model,ComplaintBean complaintBean)
	{
		model.addAttribute("complaintRaise",complaintBean);
		service.addComplaint(complaintBean);
		System.out.println(complaintBean);
		model.addAttribute("complaintsucess",complaintBean);
		return "complaintSuccess";
	}
	
	@RequestMapping(value="/checkStatusComplaint")
	public String complaintStatusPage(Model model)
	{
		model.addAttribute("statusComplaint",complaintBean);
		return "checkStatus";
	}
	
	@RequestMapping(value="/retrievecomplaint")
	public String retrieveComplaint(Model model,ComplaintBean complaintBean)
	{
		int complaintId = complaintBean.getComplaintId();
		complaintBean = service.getComplaintStatus(complaintId);
		model.addAttribute("statusComplaint",complaintBean);
		model.addAttribute("complaintStatus",complaintBean);
		return "checkStatus";
	}
	
	

}
