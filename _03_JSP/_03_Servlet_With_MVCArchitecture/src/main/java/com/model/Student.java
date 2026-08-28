package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.config.JDBC_Config;

public class Student {
	private String sname;
	private String semail;
	private String spassword;
	private String scnfPassword;
	
	private Connection con = null;
	private PreparedStatement psmnt = null;
	int row;
	
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSemail() {
		return semail;
	}


	public void setSemail(String semail) {
		this.semail = semail;
	}


	public String getSpassword() {
		return spassword;
	}


	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}


	public String getScnfPassword() {
		return scnfPassword;
	}


	public void setScnfPassword(String scnfPassword) {
		this.scnfPassword = scnfPassword;
	}


	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	public PreparedStatement getPsmnt() {
		return psmnt;
	}


	public void setPsmnt(PreparedStatement psmnt) {
		this.psmnt = psmnt;
	}


	public int register()
	{
		try
		{
		con = JDBC_Config.getDBConnection();
		psmnt = con.prepareStatement("insert into student(sname , semail , spassword , scnfPassword) values (?,?, ? , ?)");
		psmnt.setString(1, sname);
		psmnt.setString(2, semail);
		psmnt.setString(3, spassword);
		psmnt.setString(4, scnfPassword);
		
		 row =  psmnt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				JDBC_Config.closeConnection(con , psmnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return row;
				
	
	}
}
