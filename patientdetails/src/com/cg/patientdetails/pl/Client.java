package com.cg.patientdetails.pl;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.patientdetails.dto.PatientBean;
import com.cg.patientdetails.exception.PatientException;
import com.cg.patientdetails.service.PatientService;
import com.cg.patientdetails.service.PatientServiceImpl;

public class Client {
	
	static PatientService service = new PatientServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice = 0;
		
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("1-insert");
				System.out.println("2-get record by id");
				System.out.println("3-get all records");
				
				System.out.println("Enter choice");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 :
					System.out.println("enter name");
					String name = sc.next();
					System.out.println("address");
					String address = sc.next();
					System.out.println("phone num");
					String phone = sc.next();
					
					PatientBean bean = new PatientBean();
					bean.setpName(name);
					bean.setAddress(address);
					bean.setMobile(phone);
					if(service.Validate(bean))
					{
					try{
						boolean flag = service.insertDetails(bean);
						if(flag)
							System.out.println("Successffully");
					}catch(PatientException e)
					{
					System.out.println(e.getMessage());
					}
					}
					else
					{
						System.out.println("Invalid Values");
					}
					break;
					
					case 2:
						System.out.println("Enter tpatient id");
						int id = sc.nextInt();
						try
						{
							PatientBean record = service.getRecord(id);
							System.out.println(record);
							
					
					//PatientBean bean
				}catch (PatientException e){
						System.out.println(e.getMessage()); 
			}
			break;
			case 3:
				try{
				ArrayList<PatientBean> list = service.getAllRecords();
				for(PatientBean obj:list)
				{
					System.out.println(obj);
				}
		}catch (PatientException e)
				{
					System.out.println(e.getMessage());
				
				
				
				
			}
				}

				}while(choice!=1);
		
		}
	}
}


