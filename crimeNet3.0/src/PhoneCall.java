


public class PhoneCall extends Communication{
	int minute;

	
	public PhoneCall(String caller, String receiver, int day, int month, int year, int minute) {
		super(caller, receiver, day, month, year);
		this.minute= minute;
	}

	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + minute);
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	
	
}
