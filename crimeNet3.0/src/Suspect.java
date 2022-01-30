import java.util.ArrayList;

public class Suspect {
	private String name;
	private String CodeName;
	private String address;
	private ArrayList<String> Phone = new ArrayList<>();
	public ArrayList<Suspect> Possible = new ArrayList<Suspect>();
	private ArrayList<Suspect> listOfPossiblePartners = new ArrayList<>();
		
	
	public Suspect(String name, String CodeName, String address) {
		super();
		this.name = name;
		this.CodeName = CodeName;
		this.address = address;
	}
	public Suspect() {

	}
	public void addNumber(String number) {
		Phone.add(number);
	}
	
	
	
	public ArrayList<String> getNumList() {
        return Phone;
    }
	public String getCodeName() {
		return CodeName;
	}
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void addPossiblePartner(Suspect sus) 
    {	
			listOfPossiblePartners.add(sus);		
    }
	
	public boolean isConnectedTo(Suspect aSuspect) {
	
		for(int i=0; i<listOfPossiblePartners.size(); i++) {
			if(listOfPossiblePartners.get(i)==aSuspect)
			{
				return true;
			}
		}
		
		return false;
		
	}
	public void PrintInfo() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Suspect> getPartners() {
		return listOfPossiblePartners;
	}
	
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspsect)
	{
		
		ArrayList<Suspect>commPart = new ArrayList<Suspect>();
		
		for(Suspect sus : listOfPossiblePartners) 
		{
				if(sus.isConnectedTo(aSuspsect)) 
				{
					if(!commPart.contains(sus))
					{
						commPart.add(sus);
					}
				}
		}
		return commPart;
	}
	
    
	public ArrayList<Suspect> getlist()
	{
		return Possible;
		
	}
    


}


