package test.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import test.Config.FetchStaff;
import test.Model.Staff;

public class StaffDao 
{
	JdbcTemplate t1;

	public void setT1(JdbcTemplate t1) {
		this.t1 = t1;
	}
	
	
	public void add(Staff s1)
	{
		t1.update("insert into staff(sname , semail , spassword , scnfPassword) values ('"+s1.getSname()+"' , '"+s1.getSemail()+"' , '"+s1.getSpassword()+"' , '"+s1.getScnfPassword()+"' );");
	}
	
	
	public List<Staff> fetchAllData()
	{
		List<Staff> l1 =  t1.query("select * from staff order by sid asc ;", new FetchStaff());
		return l1;
	}


	public void deleteData(int id) {

		t1.update("delete from staff where sid = '"+id+"' ;");
		
	}


	// fetch data by the id
	public List<Staff> fetchData(int id) {
		List<Staff> l1 =  t1.query("select * from staff where sid = '"+id+"' ", new FetchStaff());
		return l1;
	}
	
//	update data method
	public void updateData(Staff s1)
	{
		t1.update("update staff set sname= '"+s1.getSname()+"' , spassword='"+s1.getSpassword()+"' , scnfPassword= '"+s1.getScnfPassword()+"' where sid = '"+s1.getSid()+"' ;");
	}
	
	// for the login 
	public List<Staff> checkLog(String email , String password)
	{
		List<Staff> l2 =  t1.query("select * from staff where semail='"+email+"' and spassword = '"+password+"' ; ", new FetchStaff());
		return l2;
	}

	
	
}
