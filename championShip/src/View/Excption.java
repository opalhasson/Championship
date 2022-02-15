package View;

public class Excption extends Exception {
	private String msg;
	
	public Excption(String msg) {
		this.msg=msg;
	}
	
	public String getMessage() {
		return msg;
	} 
	

}
