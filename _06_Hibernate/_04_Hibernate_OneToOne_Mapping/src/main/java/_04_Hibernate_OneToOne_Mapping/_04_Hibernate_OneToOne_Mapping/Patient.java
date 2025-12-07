package _04_Hibernate_OneToOne_Mapping._04_Hibernate_OneToOne_Mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	private int pid;
	private String pname;
	private String pdisease;
	@OneToOne
	private Doctor d;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdisease() {
		return pdisease;
	}
	public void setPdisease(String pdisease) {
		this.pdisease = pdisease;
	}
	public Doctor getD() {
		return d;
	}
	public void setD(Doctor d) {
		this.d = d;
	}
	
	
}
