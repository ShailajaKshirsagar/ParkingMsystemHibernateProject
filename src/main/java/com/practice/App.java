package com.practice;
import java.util.Scanner;
import com.practice.Repository.UserRepository;
//main class
public class App 
{
    public static void main( String[] args )
    {
    	UserRepository repo = new UserRepository();
    	boolean exit = false;
    	System.out.println("-----------------------------Parking Management System --------------------------");
    	
    	Scanner sc = new Scanner(System.in);
    	while(!exit) {
        	System.out.println("\nWhich operation do you want to perform ? ");    	
    		System.out.println("1.Insert user details ");
    		System.out.println("2.View all parked vehicles details");
    		System.out.println("3.View single data by id ");
    		System.out.println("4.Delete specific data ");
    		System.out.println("5.Update data ");
    		System.out.println("6.Exit\n");
        	int choice = sc.nextInt();
    		
    		switch(choice) {
    		
    		case 1 : 
    			repo.InsertDetails(sc);
    			break;
    			
    		case 2 :
    			repo.getAllDetails(sc);
    			break;
    			
    		case 3 :
    			repo.getSingleData(sc);
    			break;
    			
    		case 4 :
    			repo.removeData(sc);
    			break;
    			
    		case 5:
    			repo.updateData(sc);
    			break;
    			
    		case 6 : 
    			System.out.println("Exiting the application.....");
    			exit = true;
    			break;
    			
    		default :
    			System.out.println("Invalid choice!!");
    		}
    	}
    	//HibernateUtility.getSessionFactory();
    }
}
