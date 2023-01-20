package com.Miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class History {
	private String HisName;
	private String pname;
	private int qty;
//-------------------------------------------------------------------------------------------	
	public String getHisName() {
		return HisName;
	}

	public void setHisName(String HisName) {
		this.HisName = HisName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setHistory( )throws Exception
	{
		System.out.println(" ********************** IN SET HISTORY ***********************************");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
		Statement st= con.createStatement();
		String qry=" INSERT INTO HISTORY (User_Name,Product_Bought,Quantity_Ordered) VALUES('"+getHisName()+"','"+getPname()+"','"+getQty()+"')";
		st.executeUpdate(qry);
	}
	
}
