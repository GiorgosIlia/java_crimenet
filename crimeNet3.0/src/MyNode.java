

class MyNode 
{
	private int id; // good coding practice would have this as private
	
	public MyNode(int id) 
	{
		this.id = id;
	}
	public String toString() 
	{ 		
		return "V"+id; // JUNG2 makes good use of these.
	}
}
class MyLink 
{
	private double capacity; // should be private
	private double weight; // should be private for good practice
	private int id;
	
	
	public MyLink(double weight, double capacity) 
	{
		this.id = id++; // This is defined in the outer class.
		this.weight = weight;
		this.capacity = capacity;
	}
	
	public String toString() 
	{ 
		return "E"+id;
	}
}