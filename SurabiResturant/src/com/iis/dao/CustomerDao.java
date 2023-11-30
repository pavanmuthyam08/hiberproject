package com.iis.dao;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.iis.entity.Customer;
import com.iis.sessionfactory.SessionConnection;
import java.util.*;
public class CustomerDao {
	private SessionFactory sesfact;
	private Session ses;
	private Transaction tx;
	Customer custobj;
	Scanner sc;
	public CustomerDao()
	{
		sesfact=SessionConnection.getConnection();
		custobj=new Customer();
		sc=new Scanner(System.in);
	}
    public void customerValidation(String username,String password)
    {
    	ses=sesfact.openSession();
    	tx=ses.beginTransaction();
    	Query q=ses.createQuery("From Customer c where c.username=:uname and c.password=:pwd");
    	q.setParameter("uname", username);
    	q.setParameter("pwd", password);
    	List<Customer> userlist=q.list();
    	if(!userlist.isEmpty())
    	{
    		System.out.println("----Welcome to Customer Page------");
    	}
    	else
    	{
    		custobj.setUsername(username);
    		custobj.setPassword(password);
    		System.out.println("Enter The Customer id..");
    		custobj.setCustomerid(sc.nextInt());
    		System.out.println("Enter The Phone Nuber..");
    		custobj.setPhonenumber(sc.nextLong());
    		ses.save(custobj);
    		tx.commit();
    		System.out.println("-----Welcome To Customer Page-----");
    	}
    	
    }
    
}
