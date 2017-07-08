package com.cg.patientdetails.dto;

public class PatientBean {
	
	private int pId;
	private String pName;
	private String address;
	private String mobile;

	
	@Override
	public String toString() {
		return "PatientBean [pId=" + pId + ", pName=" + pName + ", address="
				+ address + ", mobile=" + mobile + "]";
	}
	/*public PatientBean(int pId, String pName, String address, String mobile) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.address = address;
		this.mobile = mobile;
	}*/
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
