package com.iis.dao;
import java.util.*;
import com.iis.entity.Customer;
import com.iis.entity.Item;
import com.iis.sessionfactory.SessionConnection;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.iis.service.*;
public class AdminDao {
	private SessionFactory sesfact;
   private Session ses;
    private Scanner sc;
    AdminService adminservice;
	public AdminDao()
	{
		sesfact=SessionConnection.getConnection();
		sc=new Scanner(System.in);
		adminservice=new AdminService();
	}
	public void adminValidation(String username, String password)
	{
		
		if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
		{
			System.out.println(".....Welcome To Admin Page......");
			adminservice.adminOperations();
			
		}
		else
		{
			System.out.println("OOPS!..You Enter The Wrong Username or Password");
		}
	}
   	 
    
	public void insertItem(List<Item> itemlist) {
		ses=sesfact.openSession();
		ses.beginTransaction();
		for(Item item:itemlist)
		{
			Item item2 = new Item();
			item2.setItemcode(item.getItemcode());
			item2.setItemname(item.getItemname());
			item2.setPrice(item.getPrice());
			ses.save(item);	
		}
		ses.beginTransaction().commit();
		System.out.println("Item Details saved");
		
	}
	/*public void insertItem(Item item) {
		ses=sesfact.openSession();
		ses.beginTransaction();
		ses.save(item);
		ses.beginTransaction().commit();
		
	}*/
	public void retriveCustomers() {
		ses=sesfact.openSession();
		Query q=ses.createQuery("from Customer");
		List<Customer> custlist=q.list();
		if(!custlist.isEmpty())
		{
		for(Customer c:custlist)
		{
			System.out.println("The Customer Id : "+c.getCustomerid());
			System.out.println("The Phone Number of Customer :"+c.getPhonenumber());
			System.out.println("---------------------------------------------------------");
		}
		}
		else
		{
			System.out.println("There is No Customers Present");
		}
	}
	public void updateCutomerDetails(int id) {
		ses=sesfact.openSession();
		ses.beginTransaction();
		Query q=ses.createQuery("from Customer c where c.customerid=:custid");
		q.setParameter("custid", id);
	    List<Customer> custlist=q.list();
	    if(!custlist.isEmpty())
	    {
	    	for(Customer c:custlist)
	    	{
	    	System.out.println("Enter Phone Number You want to update ");
	    	   c.setPhonenumber(sc.nextLong());
	    	   ses.save(c);
		    	ses.beginTransaction().commit();
		    	System.out.println("Phone Number is Updates");
	    	}
	    }
	    else
	    {
	    	System.out.println("No Customer Found....");
	    }
		
	}
	public void deleteCutomer(int id) {
		
		ses=sesfact.openSession();
		Query q=ses.createQuery("delete from Customer c where c.customerid:id");
		q.setParameter("id", id);
		List<Customer> custlist=q.list();
		if(!custlist.isEmpty())
		{
			System.out.println("Customer Was Deleted...");
		}
		else
		{
			System.out.println("No Customer Found..!");
		}
	}
	public void createCustomer(List<Customer> custlist) {
		ses=sesfact.openSession();
		ses.beginTransaction();
		for(Customer list:custlist)
		{
			Customer cust=new Customer();
			cust.setCustomerid(list.getCustomerid());
			cust.setUsername(list.getUsername());
			cust.setPassword(list.getPassword());
			cust.setPhonenumber(list.getPhonenumber());
			ses.save(cust);
		}
		ses.beginTransaction().commit();
		System.out.println("The Customers are Saved..");
		
	}

	
	
}
