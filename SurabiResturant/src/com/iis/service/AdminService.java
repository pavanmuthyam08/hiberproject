package com.iis.service;
import com.iis.entity.Item;
import com.iis.dao.AdminDao;
import com.iis.entity.Customer;
import java.util.*;
public class AdminService {
   AdminDao admindao;
   Scanner sc;
   List<Item> itemlist;
   List<Customer> custlist;
   public AdminService()
   {
	   admindao=new AdminDao();
	   sc=new Scanner(System.in);
	   itemlist=new ArrayList<>();
	   custlist=new ArrayList<>();
   }
   public void checkAdmin()
   {
	   System.out.println("Enter the UserName");
	   String username=sc.next();
	   System.out.println("Enter Password");
	   String password=sc.next();
	   admindao.adminValidation(username,password);
   }
   public void adminOperations()
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
  			 insertItem();
  			 break;
  		 case 2:
  			createCustomer();
  			 break;
  		 case 3:
  			retriveCustomer();
  			 break;
  		 case 4:
  			updateCustomer();
  			 break;
  		 case 5:
  			deleteCustomer();
  			 break;
  		 case 6:
  			 System.exit(0);
  			 break;
  		 }
  		 System.out.println("If You want to Continue Enter(Y) else Enter (N)");
  		 ch=sc.next();
  	 }
   }
   public void insertItem()
   {
	   System.out.println("Enter How Many Items You Want to insert..");
	   int noofitem=sc.nextInt();
	   for(int x=0;x<noofitem;x++)
	   {
		   Item item=new Item();
		   System.out.println("Enter The Item Code");
		   item.setItemcode(sc.nextInt());
		   item.setItemcode(sc.nextInt());
		   System.out.println("Enter The Item Name ");
		   item.setItemname(sc.next());
		   System.out.println("Enter the Price of Item");
		   item.setPrice(sc.nextDouble());
		   itemlist.add(item);
	   }
	   admindao.insertItem(itemlist);
   }
   public void retriveCustomer()
   {
	   admindao.retriveCustomers();
   }
   public void updateCustomer()
   {
	   System.out.println("Enter Customer Id you want to update");
	   int id=sc.nextInt();
	   admindao.updateCutomerDetails(id);
   }
   public void deleteCustomer()
   {
	   System.out.println("Enter Customer Id you want to update");
	   int id=sc.nextInt();
	   admindao.deleteCutomer(id);
   }
   public void createCustomer()
   {
	   System.out.println("Enter How Many Customer Do You Want to Insert...");
	   int noofcust=sc.nextInt();
	   for(int x=0;x<noofcust;x++)
	   {
		   Customer cust=new Customer();
		   System.out.println("Enter The Customer Id");
		   cust.setCustomerid(sc.nextInt());
		   System.out.println("Enter customer username");
		   cust.setUsername(sc.next());
		   System.out.println("Enter password of Customer");
		   cust.setPassword(sc.next());
		   System.out.println("Enter The Phone Number of Customer");
		   cust.setPhonenumber(sc.nextLong());
		   custlist.add(cust);
	   }
	   admindao.createCustomer(custlist);
   }
   /*public static void main(String[] args) {
	AdminService aser=new AdminService();
	aser.checkAdmin();
}*/
}
