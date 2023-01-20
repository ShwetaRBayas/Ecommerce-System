package com.Miniproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ExistingUser extends NewUser
{
	public void userLog() throws Exception
	{
		char a='Y';
		while(a=='Y'||a=='y') 
		{
			System.out.println("\n"+"-*-*-*-*-*-*-* WELCOME TO A-MART ONLINE PURCHASE PORTAL *-*-*-*-*-*-*-*-*-*-"+"\n");
			System.out.println("To Continue Validate yourself first:");
			Scanner sc3 = new Scanner(System.in);
			System.out.print("Enter your Name: ");
			String name=sc3.nextLine();
			System.out.print("Enter your Registered Mobile number: ");
			long mob=sc3.nextLong();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("SELECT User_ID FROM USER WHERE User_Name='"+name+"' AND Mobile_No= '"+mob+"'");
			if(rs.next()) 
			{
				System.out.println("WELCOME "+name);
				userInterface(name);
				break;
			}

			else 
			{
				System.out.println("Either Name or Mobile Number is incorrect");
				System.out.println("Do You want to retry(Y/N)");
				a=sc3.next().charAt(0);
				if (a=='n'||a=='N')
					newUserRegistration();

			}
			
		}
	}
	
	public void viewProductTable() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM PRODUCT");
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("Product ID "+" "+" Product Name "+" "+"         Price "+"         Stock Available "+"         Product Description ");
		System.out.println("______________________________________________________________________________________________________");
		while(rs.next()) 
		{
			System.out.println("   "+rs.getInt(1)+"             "+rs.getString(2)+"                "+rs.getString(3)+"                "+rs.getString(4)+"                "+rs.getString(5));
			System.out.println("------------------------------------------------------------------------------------------------------");
		}
		st.close();
		con.close();
	}
	
	public void viewRegisteredUsersTable() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM USER");
		System.out.println("___________________________________________________________________________________________________________________");
		System.out.println("USER ID "+" "+" Customer Name "+" "+"         Gender "+"         Mobile No. "+"         Address ");
		System.out.println("___________________________________________________________________________________________________________________");
		while(rs.next()) 
		{
			System.out.println(" "+rs.getInt(1)+"      "+rs.getString(2)+"                "+rs.getString(3)+"            "+rs.getString(4)+"           "+rs.getString(5));
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
		}
		st.close();
		con.close();
	}
	
	public void viewPurchaseHistoryTable() throws Exception
	{
		Scanner Sc=new Scanner(System.in);
		int z;
		System.out.println("Press 1. to fetch entire Purchase History Table");
		System.out.println("Press 2. to Customer Specific Purchase History Table");
		z=Sc.nextInt();
		switch(z) 
		{
		case 1: allHistoryTable();
			    break;
		case 2: userSpecificHistory();
			    break;
		default:System.out.println("Invalid Input...! Please select among the given options only");
		        break;
		}

	}

	private void userSpecificHistory() throws Exception 
	{
		String CustName;
		System.out.println("The following is the list of Registered Customer with us who have a Purchase History.");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT DISTINCT USER_NAME FROM History");
		System.out.println("_________________");
		System.out.println(" Customer Name ");
		System.out.println("_________________");
		while(rs.next()) 
		{
			System.out.println(" "+rs.getString(1));
			System.out.println("-----------------");
		}
		System.out.println("\n");
		System.out.print("Please Enter the Name of the Customer you want to see Purchase History of:");
		Scanner ip=new Scanner(System.in);
		CustName=ip.nextLine();
		ResultSet rs1= st.executeQuery("SELECT * FROM History WHERE User_Name = '"+CustName+"'");
		System.out.println("____________________________________________________________________________________");
		System.out.println("History ID "+" "+" Customer Name "+" "+"         Product Bought "+"         Quantity Purchased ");
		System.out.println("____________________________________________________________________________________");
		while(rs1.next()) 
		{
			System.out.println(" "+rs1.getInt(1)+"              "+rs1.getString(2)+"                "+rs1.getString(3)+"                      "+rs1.getString(4));
			System.out.println("------------------------------------------------------------------------------------");
		}
		st.close();
		con.close();
		
		
	}

	private void allHistoryTable() throws Exception 
	{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM HISTORY");
		System.out.println("____________________________________________________________________________________");
		System.out.println("History ID "+" "+" Customer Name "+" "+"         Product Bought "+"         Quantity Purchased ");
		System.out.println("____________________________________________________________________________________");
		while(rs.next()) 
		{
			System.out.println(" "+rs.getInt(1)+"              "+rs.getString(2)+"                "+rs.getString(3)+"                      "+rs.getString(4));
			System.out.println("------------------------------------------------------------------------------------");
		}
		st.close();
		con.close();
		
	}
}
