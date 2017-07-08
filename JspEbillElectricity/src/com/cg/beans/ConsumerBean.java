package com.cg.beans;

public class ConsumerBean {
	
	private int consumer_num;
	private String consumer_name;
	private String address;
	
	@Override
	public String toString() {
		return "ConsumerBean [consumer_num=" + consumer_num
				+ ", consumer_name=" + consumer_name + ", address=" + address
				+ "]";
	}
	public int getConsumer_num() {
		return consumer_num;
	}
	public void setConsumer_num(int consumer_num) {
		this.consumer_num = consumer_num;
	}
	public String getConsumer_name() {
		return consumer_name;
	}
	public void setConsumer_name(String consumer_name) {
		this.consumer_name = consumer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/* CONSUMER_NUM
 CONSUMER_NAME
 ADDRESS*/
	

}
