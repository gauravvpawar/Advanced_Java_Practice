package _04_Hibernate_OneToOne_Mapping._04_Hibernate_OneToOne_Mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Doctor 
{
	@Id
	private int did;
	private String dname;
	private String demail;
	
	@OneToOne
	private Patient p;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

	public Patient getP() {
		return p;
	}

	public void setP(Patient p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", demail=" + demail + ", p=" + p + "]";
	}
	
	
}
