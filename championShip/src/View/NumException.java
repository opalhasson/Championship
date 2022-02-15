package View;

public class NumException extends NumberFormatException{
	private String msg;

	public NumException(String msg) {
		this.msg=msg;
	}

	public String getMessage() {
		return msg;
	} 


}
