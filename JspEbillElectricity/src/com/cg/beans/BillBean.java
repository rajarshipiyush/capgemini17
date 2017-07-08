package com.cg.beans;

import java.time.LocalDate;

public class BillBean {
	
	private int bill_num;
	private int consumer_num;
	private double cur_reading;
	private double unit_consumed;
	private double netamount;
	private LocalDate bill_date;
	
	@Override
	public String toString() {
		return "BillBean [bill_num=" + bill_num + ", consumer_num="
				+ consumer_num + ", cur_reading=" + cur_reading
				+ ", unit_consumed=" + unit_consumed + ", netamount="
				+ netamount + ", bill_date=" + bill_date + "]";
	}
	/*
	 *  BILL_NUM
 		CONSUMER_NUM
 		CUR_READING
 		UNITCONSUMED
 		NETAMOUNT
 		BILL_DATE
 		 */
	
	public int getBill_num() {
		return bill_num;
	}
	public void setBill_num(int bill_num) {
		this.bill_num = bill_num;
	}
	public int getConsumer_num() {
		return consumer_num;
	}
	public void setConsumer_num(int consumer_num) {
		this.consumer_num = consumer_num;
	}
	public double getCur_reading() {
		return cur_reading;
	}
	public void setCur_reading(double cur_reading) {
		this.cur_reading = cur_reading;
	}
	public double getUnit_consumed() {
		return unit_consumed;
	}
	public void setUnit_consumed(double unit_consumed) {
		this.unit_consumed = unit_consumed;
	}
	public double getNetamount() {
		return netamount;
	}
	public void setNetamount(double netamount) {
		this.netamount = netamount;
	}
	public LocalDate getBill_date() {
		return bill_date;
	}
	public void setBill_date(LocalDate bill_date) {
		this.bill_date = bill_date;
	}
	
	

}
