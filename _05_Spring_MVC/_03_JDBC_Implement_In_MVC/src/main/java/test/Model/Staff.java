package test.Model;

public class Staff 
{
	private int sid;
	private String sname;
	private String semail;
	private String spassword;
	private String scnfPassword;
	
	
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
	@Override
	public String toString() {
		return "Staff [sname=" + sname + ", semail=" + semail + ", spassword=" + spassword + ", scnfPassword="
				+ scnfPassword + "]";
	}
	
	
	
}
