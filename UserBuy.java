package com.Miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserBuy extends CalculateBill
{
	public void userInterface(String name) throws Exception 
	{
		// TODO Creating Connection
		CalculateBill bill= new CalculateBill();
		System.out.println("\n"+"-*-*-*-*-*-*-* WELCOME TO A-MART ONLINE PURCHASE PORTAL *-*-*-*-*-*-*-*-*-*-"+"\n");
		System.out.println("WELCOME "+name);
		System.out.println("Please go through the Product Menu and Shop to your hearts content"+"\n");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * FROM PRODUCT");
		System.out.println("______________________________________________________________________________________________________");
		System.out.println("Product ID "+" "+" Product Name "+" "+"     Price ");
		System.out.println("______________________________________________________________________________________________________");
		while(rs.next()) 
		{
			System.out.println("   "+rs.getInt(1)+"             "+rs.getString(2)+"         "+rs.getString(3));
			System.out.println("------------------------------------------------------------------------------------------------------");
		}
		st.close();
		con.close();
		Scanner sc= new Scanner(System.in);
		String op;
		do 
		{
			System.out.println("Please Enter the Product ID and Quantity of the Product you want to buy: ");
			int PI=sc.nextInt();
			int Qty=sc.nextInt();
			bill.calculateBill(PI, Qty, name);
			System.out.println("Do you want to add more product to your cart:");
			System.out.println("Press 'Y' for Yes and 'N' for no :");
			op=sc.next();
			
			
		}while(op.charAt(0)=='Y'||op.charAt(0)=='y');
		System.out.println("Final Bill is: "+bill.getFinalBill());

	}
	
}

