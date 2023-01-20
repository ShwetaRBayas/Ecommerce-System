package com.Miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class NewUser extends UserBuy
{
	private String name;
	private String gender;
	private String address;
	private String email;
	private long mobileNo;
//------------------------------------------	gender
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
//------------------------------------------	address
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//------------------------------------------    email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//------------------------------------------	mobileNo
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
//------------------------------------------	name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//------------------------------------------	newUserRegistration Method
	public void newUserRegistration() throws Exception
	{ 
		System.out.println("   ------- Welcome to New User Registration Portal -------  "+"\n");
		System.out.println("\n"+"-*-*-*-*-*-*-* WELCOME TO A-MART ONLINE PURCHASE PORTAL *-*-*-*-*-*-*-*-*-*-"+"\n");
		System.out.println("In order to begin wonderful experince of Shopping from A-Mart you need to register yourself first, Kindly follow the process and get yourself registered."+"\n");
		System.out.println("Please fill out the folowing details: ");
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		System.out.print("Name: ");
		setName(sc.nextLine());
		
		System.out.print("Gender(Male/Female): ");
		setGender(sc.nextLine());
		
		System.out.print("Mobile: ");
		setMobileNo(sc.nextLong());
		
		System.out.print("Address: ");
		setAddress(sc1.nextLine());
		
		System.out.println("\n");
		//----------------------------------------------------------------------------------------------------------------
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		String qry=" INSERT INTO USER(User_Name,Gender,Mobile_No,Address) VALUES('"+getName()+"','"+getGender()+"','"+getMobileNo()+"','"+getAddress()+"')";
		st.executeUpdate(qry);
		userInterface(name);

	}
}
