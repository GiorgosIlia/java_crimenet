import java.util.ArrayList;


public class Registry 
{

	String caller;
	String receiver;
	int day;
	int month;
	int year;
	
	private ArrayList<Suspect> sus = new ArrayList<Suspect>();
	private ArrayList<Communication> comm = new ArrayList<>();

	

	
	public Registry(String caller, String receiver, int day, int month, int year) 
	{
		super();
		this.caller = caller;
		this.receiver = receiver;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public ArrayList<Communication> getComm() 
	{
		return comm;
	}
	public void setComm(ArrayList<Communication> comm) 
	{
		this.comm = comm;
	}
	public Registry() 
	{
		sus = new ArrayList<Suspect>();
		comm = new ArrayList<Communication>();
	}
	public void addSuspect(Suspect aSuspect) 
	{
		sus.add(aSuspect);
		
	}
	public void printInfo() 
	{
		System.out.println("Between " + caller + " --- " + receiver + "\non "+year+"/"+month+"/"+day);
	}
	

	
 

	public void addCommunication(Communication aCommunication) 
	{
		String num1 = aCommunication.getCaller();
		String num2 = aCommunication.getReceiver();
		
		Suspect sus1 = null;
		Suspect	sus2 = null;
			
		int i,j;
		
		comm.add(aCommunication);		
		
		for(i=0; i<sus.size(); i++) 
		{		
			for(j=0; j<sus.get(i).getNumList().size(); j++) 
			{
				if(sus.get(i).getNumList().get(j)== num1) 
				{
					sus1= sus.get(i);
				}
				else if(sus.get(i).getNumList().get(j)== num2) 
				{
					sus2 = sus.get(i);
				}
			}
		}	
		sus1.addPossiblePartner(sus2);
		sus2.addPossiblePartner(sus1);
	}
	
	public PhoneCall getLongestPhoneCallBetween(String num1,String num2)
	{
		int max = 0;
		PhoneCall p1=null;
		for(Communication coms : comm) 
		{
			String arithmos1 = coms.getCaller();
			String arithmos2 = coms.getReceiver();
			
			if(arithmos1 == num1 && arithmos2==num2 ) 
				{
				if(coms.getMinute() > max)
				{
					max=coms.getMinute();
					p1 = (PhoneCall) coms;
				}
			}
		}
		return p1;
	}
	
	public Suspect getSuspectWithMostPartners()
	{
		Suspect s1 = null;
		int max=0;
		for(Suspect su : sus)
		{
			if(su.getPartners().size()>max)
			{
				max=su.getPartners().size();
				s1= su;
			}
		}
		return s1 ;		
	}
	
	public ArrayList<Sms> getMessagesBetween(String num1, String num2)
	{
		ArrayList<Sms> sms1 = new ArrayList<Sms>();
	
		for(Communication sms:comm)
		{
			String arithmos1 = sms.getCaller();
			String arithmos2 = sms.getReceiver();
			
			
			if(arithmos1 == num1 && arithmos2==num2 )
			{
				if(sms.getMessage().contains("Bomb")||sms.getMessage().contains("Gun")||sms.getMessage().contains("Explosives")||sms.getMessage().contains("Attack"))
				{
					sms1.add((Sms) sms);
				}
			}
		}
		return sms1;
	}	


}
