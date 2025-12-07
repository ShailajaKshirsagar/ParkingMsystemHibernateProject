package com.practice.Repository;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.practice.Entity.UserDetails;
import com.practice.Utility.HibernateUtility;

//repo added
public class UserRepository {
	
	//Create / insert data 
	public void InsertDetails(Scanner sc ) {
		UserDetails u = new UserDetails();
		
		System.out.println("Enter Id : ");
		int id = sc.nextInt();

		System.out.println("Enter your name : ");
		String name = sc.next();
		
		System.out.println("Enter flat no : ");
		int flat_no = sc.nextInt();
		
		System.out.print("Enter resident type (Owner/Tenant): ");
		sc.nextLine(); // consume newline after previous nextInt()
		String tenant_owner = sc.nextLine(); // directly store the string
		
		System.out.println("Your vehicle type (Car / Bike) :  ");
		String  vehicle_type = sc.next();
		
		System.out.println("Enter your contact number : ");
		long contact_no = sc.nextLong();
		
		//set values
		u.setId(id);
		u.setName(name);
		u.setFlat_no(flat_no);
		u.setTenant_owner(tenant_owner);
		u.setVehicle_type(vehicle_type);
		u.setContact_no(contact_no);
		
		//create session and save details 
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//save details 
		session.persist(u);
		
		transaction.commit();
		session.close();
		
		System.out.println("User Details added successfully!\n");
	}
	
	//Read all details
	public void getAllDetails(Scanner sc) {
		
		System.out.println("------------------All Parked Vehicle user Details --> ");
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		List<UserDetails> userList = session.createQuery("select u from UserDetails u",UserDetails.class).getResultList();
		userList.stream().forEach( a -> System.out.println(a.toString()));
		
		transaction.commit();
		session.close();	
	}
	
	//Get single data by primary key 
	public void getSingleData(Scanner sc) {
		
		System.out.println("\nEnter the id of user whose details you want to check ? ");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction =session.beginTransaction();
		
		UserDetails UserId = session.find(UserDetails.class, id);
		System.out.println(UserId.toString());
		
		transaction.commit();
		session.close();
	}
	
	//Remove data 
	public void removeData(Scanner sc) {
		System.out.println("Enter the id of user whose data you want to delete?");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		UserDetails deleteId = session.find(UserDetails.class, id);
		session.remove(deleteId);
		
		transaction.commit();
		session.close();
		
		System.out.println("User with ID " + id + " Data Deleted ");
	}
	
	//update data
	public void updateData(Scanner sc) {
		
		System.out.println("Enter the ID of user whose data you want to update ? ");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		UserDetails updateId= session.find(UserDetails.class, id);
		
		System.out.println("Enter new Updated name : ");
		String name = sc.next();
		
		System.out.println("Enter flat number : ");
		int flat_no = sc.nextInt();
		
		System.out.println("Are you owner or Tenant ? ");
		String owner = sc.next();
		
		System.out.println("Enter your vehicle type : ");
		String vehicle = sc.next();
		
		System.out.println("Enter contact number : ");
		long contact = sc.nextLong();
		
		updateId.setName(name);
		updateId.setFlat_no(flat_no);
		updateId.setTenant_owner(owner);
		updateId.setVehicle_type(vehicle);
		updateId.setContact_no(contact);
		
		transaction.commit();
		session.close();
		
		System.out.println("User with ID "+id+" Data Updated");
	}
}
