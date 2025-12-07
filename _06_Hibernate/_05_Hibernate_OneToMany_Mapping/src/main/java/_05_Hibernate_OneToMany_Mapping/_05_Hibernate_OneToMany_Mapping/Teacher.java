package _05_Hibernate_OneToMany_Mapping._05_Hibernate_OneToMany_Mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher 
{
	@Id
	private int tid;
	private String tname;
	private String tsubject;
	
	@OneToMany
    private	List<Student> l1;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsubject() {
		return tsubject;
	}

	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}

	public List<Student> getL1() {
		return l1;
	}

	public void setL1(List<Student> l1) {
		this.l1 = l1;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tsubject=" + tsubject + ", l1=" + l1 + "]";
	}
    
    
}
