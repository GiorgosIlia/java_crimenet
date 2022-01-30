
public class Sms extends Communication{
	String message;
	
	
	public Sms(String caller, String receiver, int day, int month, int year, String message) {
		super(caller, receiver, day, month, year);
		 this.message=message;
	}
	
	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + message);
	}

	public String getMessage() {
		return message;
	}



}
