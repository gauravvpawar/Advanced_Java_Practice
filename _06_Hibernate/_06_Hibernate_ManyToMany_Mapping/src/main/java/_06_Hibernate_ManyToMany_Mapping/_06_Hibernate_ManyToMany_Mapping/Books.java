package _06_Hibernate_ManyToMany_Mapping._06_Hibernate_ManyToMany_Mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Books 
{
	@Id
	private int bid;
	private String bname;
	
	@ManyToMany
	private List<Authors> list;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public List<Authors> getList() {
		return list;
	}

	public void setList(List<Authors> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bname=" + bname + ", list=" + list + "]";
	}
	
	
}
