package _05_Hibernate_OneToMany_Mapping._05_Hibernate_OneToMany_Mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student_info")
public class Student 
{
	@Id
	private int sid;
	private String sname;
	private String sclass;
	
	@ManyToOne
	private Teacher t;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public Teacher getT() {
		return t;
	}

	public void setT(Teacher t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sclass=" + sclass + ", t=" + t + "]";
	}
	
	
}
