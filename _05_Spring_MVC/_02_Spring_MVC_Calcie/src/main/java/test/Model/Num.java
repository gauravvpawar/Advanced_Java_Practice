package test.Model;

public class Num 
{
	private int firstNum;
	private int secondNum;
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	@Override
	public String toString() {
		return "Num [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
	}
	
	
}
