package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component(value="complaintBean")
@Entity
@Table(name="complaint")
public class ComplaintBean {
	
	@Id
	@SequenceGenerator(name="seqComplaint",sequenceName="hibernate_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqComplaint")
	private int complaintId;
	private long accountId;
	private String branchCode;
	private String emailId;
	private String category;
	private String description;
	private String priority;
	private String status="Open";
	
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		
		if(category.equals("Internet Banking"))
		{
			setPriority("High");
		}
		else if(category.equals("General Banking"))
		{
			setPriority("Medium");
		}
		else if(category.equals("Others"))
		{
			setPriority("Low");
		}
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ComplaintBean [complaintId=" + complaintId + ", accountId="
				+ accountId + ", branchCode=" + branchCode + ", emailId="
				+ emailId + ", category=" + category + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}
	
	

}
