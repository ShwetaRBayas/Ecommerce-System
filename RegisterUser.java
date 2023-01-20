package com.Miniproject;

import java.util.Scanner;

public class RegisterUser extends Admin
{

	public static void main(String[] args) throws Exception 
	{
		// Main Class in Register user
		System.out.println("\n"+"-*-*-*-*-*-*-* WELCOME TO A-MART ONLINE PURCHASE PORTAL *-*-*-*-*-*-*-*-*-*-"+"\n");
		System.out.println("Press 1. for Admin");
		System.out.println("Press 2. for Existing user");
		System.out.println("Press 3. for New user");
		System.out.flush();
		Scanner sc=new Scanner(System.in);
		Admin ad=new Admin();
		NewUser nu= new NewUser();
		ExistingUser eu=new ExistingUser();
		int ip=sc.nextInt();
		switch(ip) 
		{
		case 1:	for(int i=0;i<50;i++)
						System.out.println("");
				ad.adminLog();
			    break;
		case 2: for(int i=0;i<50;i++)
					System.out.println("");
				eu.userLog();
			    break;
		case 3: for(int i=0;i<50;i++)
					System.out.println("");
				nu.newUserRegistration();
			    break;
		default:for(int i=0;i<50;i++)
					System.out.println("");
				System.out.println("Invalid Input...! Please select among the given options only");
		        break;
		
		}
		

	}

}

