package com.Miniproject;

import java.io.IOException;
import java.util.Scanner;

public class Admin extends ExistingUser
{
	public void adminLog() throws IOException 
	
	{
		Scanner scanner=new Scanner(System.in);
		int a;
		System.out.flush();
		System.out.println("   ------- Welcome to Admin Portal -------  ");
		System.out.println("For access of history you need to enter password and username");
		String Username= "root";
		String Password="root";
		System.out.println("Enter Your Username");
		String u=scanner.next();
		System.out.println("Enter Your Password");
		String p=scanner.next();
		
		if(u.equals(Username) && p.equals(Password)) 
		{
			System.out.println("Admin Authentication Successful......");
			System.out.println("Press 1. to view product details");
			System.out.println("Press 2. to view registered users");
			System.out.println("Press 3. to view Purchase History");
			a=scanner.nextInt();
			switch(a) 
			{
			case 1: try 
					{
						viewProductTable();
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
			case 2: try 
					{
						viewRegisteredUsersTable();
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
			case 3: System.out.println("-*-*-*-*-* PURCHASE HISTORY *-*-*-*-*-");
					try 
					{
						viewPurchaseHistoryTable();
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
			default:System.out.println("Invalid Input...! Please select among the given options only");
			        break;
			
			}
		}
		
		else 
		{
			System.out.println("...........WRONG CREDENTIALS...........");
		}
		
	}


}


