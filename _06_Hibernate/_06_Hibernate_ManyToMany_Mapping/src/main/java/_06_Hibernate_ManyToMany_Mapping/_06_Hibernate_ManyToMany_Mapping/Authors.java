package _06_Hibernate_ManyToMany_Mapping._06_Hibernate_ManyToMany_Mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Authors 
{
	@Id
	private int aid;
	private String aname;
	
	@ManyToMany
	private List<Books> list;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public List<Books> getList() {
		return list;
	}

	public void setList(List<Books> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Authors [aid=" + aid + ", aname=" + aname + ", list=" + list + "]";
	}
	
	
}
