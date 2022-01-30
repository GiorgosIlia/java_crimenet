import java.util.ArrayList;

public class Communication extends Registry{

	public Communication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Communication(String caller, String receiver, int day, int month, int year) {
		super(caller, receiver, day, month, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCaller() {
		// TODO Auto-generated method stub
		return super.getCaller();
	}

	@Override
	public String getReceiver() {
		// TODO Auto-generated method stub
		return super.getReceiver();
	}

	@Override
	public int getDay() {
		// TODO Auto-generated method stub
		return super.getDay();
	}

	@Override
	public int getMonth() {
		// TODO Auto-generated method stub
		return super.getMonth();
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return super.getYear();
	}

	@Override
	public ArrayList<Communication> getComm() {
		// TODO Auto-generated method stub
		return super.getComm();
	}

	public int getMinute() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMinute(int max) {
		// TODO Auto-generated method stub
		
	}

	public String getMessage() {
		return null;
	}
	
	
	
}
