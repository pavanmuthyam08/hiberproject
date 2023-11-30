package com.iis.service;
import com.iis.dao.CustomerDao;
import java.util.*;
public class CustomerService {
   CustomerDao custdao;
   Scanner sc;
   String username;
   String password;
   public CustomerService()
   {
	   custdao=new CustomerDao();
	   sc=new Scanner(System.in);
   }
   public void checkCustomer()
   {
	   System.out.println("Enter Your Username");
	   username=sc.next();
	   System.out.println("Enter Your Password");
	   password=sc.next();
	   custdao.customerValidation(username, password);
   }
   public void customerOperations()
   {
	   int choice;
	  	 String ch="y";
	  	 while(ch.equalsIgnoreCase("y"))
	  	 {
	  		 System.out.println();
	  		 System.out.println("------------Here is Your Operations List---------------");
	  		 System.out.println("1. Insert Items");
	  		 System.out.println("2. Add New Customers");
	  		 System.out.println("3. View All The Customers");
	  		 System.out.println("4. Update Customer Details");
	  		 System.out.println("5. Delete Customer");
	  		 System.out.println("6. Exit");
	  		 System.out.println();
	  		 System.out.println("Enter Your Choice");
	  		 choice=sc.nextInt();
	  		 switch(choice)
	  		 {
	  		 case 1:
	  			 break;
	  		 }
	  		 System.out.println("If You want to Continue Enter(Y) else Enter (N)");
	  		 ch=sc.next();
	  	 }
   }
}
