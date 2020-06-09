package GoFoBackage;

import java.util.ArrayList;
import java.util.Scanner;

public class GroundOwner extends User {
	public ArrayList<Ground> ground = new ArrayList<Ground>();
	Scanner reader = new Scanner(System.in);
	
	
	
	/**
	 * This function takes a playground name, location, area and price,
	 * then it adds this playground in this the system, 
	 * and makes it belongs to the owner who added it.
	 */
	public void addPlayground(String name, String location, float Area, int price) {
		if(ground.size()==0)
		{
			Ground g= new Ground(name,location,Area,price,getID()+10);
			ground.add(g);
		}
		else
		{
			Ground g= new Ground(name,location,Area,price,getID()+ground.get(ground.size()-1).getGroundID()+10);
			ground.add(g);
		}
	}
	
	
	
	
	/**
	 * This function allows the owner to make any update or change to their playgrounds, 
	 * changes could be for playground name, location, area and hours
	 */
	public void updatePlayground(int groundNumber, String name, String location, float area, int first, int last,int change) {
		
		if (change == 1) {
			ground.get(groundNumber).setGroundName(name);
		}
		
		else if(change == 2){
			ground.get(groundNumber).setGroundLocation(location);
		}
		
		
		else if(change == 3) {
			ground.get(groundNumber).setGroundArea(area);
		}
		
		
		else if(change == 4){
			ground.get(groundNumber).setHour(first, last);
		}
		
	}
	
	
	
	
	
	
	/**
	 * This function display the playgrounds, belongs to this owner, info.
	 * it also displays their available hours
	 */
	public void viewPlaygrounds()
	{
		for(int i=0; i<ground.size(); i++)
		{
			System.out.println("[ground=" + ground.get(i) + "]");
			ground.get(i).displayAvailableHour(); 
		}
	}
	
	
	
	
	
	/**
	 * This function displays the booking hours for their playgrounds
	 */
	public void viewBooking()
	{
		for(int i=0;i<ground.size();i++)
		{
			ground.get(i).viewBooking();
		}
	}
	/**
	 * this function to check if playground not booked
	 * @param first
	 * @param last
	 * @param groundID
	 * @return
	 */
	public Boolean checkbooking(int first, int last, int groundID) {
		Boolean flag=true;
		if(first==24)
		{
			first=0;
		}
		for(int i=0; i<ground.size();i++)
		{
			if(ground.get(i).getGroundID() == groundID&&ground.get(i).getState().equalsIgnoreCase("active"))
			{
				for(int j=first; j<=last;j++)
				{
					if(ground.get(i).getBookerID(j)==-1)
					{
						flag=true;		
					}
					else
					{
						flag=false;
						break;
					}
					
				}
			}
		}
		return flag;
	}
	
	/**
	 * This function allows the owner to book his own playgrounds and that's after
	 * the player book it first. 
	 * The function displays all the playgrounds belongs to the owner and book 
	 * the playground by using its ID, the first and last hours of its available
	 * hours, its cost and the owner ID.
	 * The function check if the ID of the playground is right and then it books it
	 * and pay its cost from the player eWallet to the owner one.
	 * @param ID
	 * @param first
	 * @param last
	 * @param cost
	 * @param groundID
	 * @return
	 */
	public int booking(int ID, int first, int last, int cost, int groundID) {
		
		for(int i=0; i<ground.size();i++)
		{
			if(ground.get(i).getGroundID() == groundID&&ground.get(i).getState().equalsIgnoreCase("active"))
			{
				groundID = i;
				break;
			}
		}
		ewallet.deposit(cost);
		return ground.get(groundID).booking(ID, first, last);
	}
	
	
	
	/**
	 * This function displays the playgrounds of the owner in order of
	 * its parameter location value.
	 * @param location
	 */
	public void Filtering(String location) {
		for(int i=0;i<ground.size();i++)
		{
			if(ground.get(i).getGroundLocation().equalsIgnoreCase(location))
			{
				System.out.println(ground.get(i));
			}
		}
	}
	
	
	
	/**
	 * This function displays the playgrounds of the owner in order of
	 * its parameter price value.
	 * @param price
	 */
	public void Filtering(int price) {
		for(int i=0;i<ground.size();i++)
		{
			if(ground.get(i).getPrice() == price)
			{
				System.out.println(ground.get(i));
			}
		}
	}
	
	
	
	/**
	 * 
	 */
	public GroundOwner() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	/**
	 * 
	 * @param iD
	 * @param userName
	 * @param mail
	 * @param password
	 * @param address
	 * @param mobile
	 * @param type
	 */
	public GroundOwner(int iD, String userName, String mail, String password, String address, String mobile, String type) {
		super(iD, userName, mail, password, address, mobile, type);
		// TODO Auto-generated constructor stub
	}


	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "owner" + "[ID=" + getID() + ", userName=" + getUserName() + ", mail=" + getMail() + ", password=" + getPassword() + ", address="
				+ getAddress() + ", mobile=" + getMobile() + ", type=" + getType()+ "]"+"[ground=" + ground + "]";
	}
	
}
