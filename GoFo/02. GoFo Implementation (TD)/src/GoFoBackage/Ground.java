package GoFoBackage;

public class Ground {

	/**
	 * @attributes
	 * groundName String
	 * groundLocation String
	 * groundArea float
	 * groundID integer
	 * state String
	 * availableHour integer[][]
	 * bookerID integer[]
	 * price integer
	 */
	private String groundName;
	private String groundLocation;
	private float groundArea;
	private int groundID;
	private String state = "notActive";
	private int [][] availableHour = {{24,1},{1,2},{2,3},{3,4},{4,5},{5,6},{6,7},{7,8},{8,9},{9,10},{10,11},{11,12},{12,13},{13,14},{14,15},{15,16},{16,17},{17,18},{18,19},{19,20},{20,21},{21,22},{22,23},{23,24}};
	private int [] bookerID = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1} ;
	private int price;
	
	
	
	
	
	
	
	/**
	 * This function returns the playground name.
	 * @return
	 */
	public String getGroundName() {
		return groundName;
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground name.
	 * @param groundName
	 */
	public void setGroundName(String groundName) {
	this.groundName = groundName;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground location.
	 * @return
	 */
	public String getGroundLocation() {
	return groundLocation;
	}

	
	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground location.
	 * @param groundLocation
	 */
	public void setGroundLocation(String groundLocation) {
	this.groundLocation = groundLocation;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground area.
	 * @return
	 */
	public float getGroundArea() {
	return groundArea;
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground area.
	 * @param groundArea
	 */
	public void setGroundArea(float groundArea) {
	this.groundArea = groundArea;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground ID.
	 * @return
	 */
	public int getGroundID() {
	return groundID;
	}

	
	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground ID.
	 * @param groundID
	 */
	public  void setGroundID(int groundID) {
	this.groundID = groundID;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground state.
	 * @return
	 */
	public String getState() {
	return state;
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground state.
	 * @param state
	 */
	public void setState(String state) {
	this.state = state;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground available hours.
	 * @return
	 */
	public int[][] getAvailableHour() {
	return availableHour;
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground available hours.
	 * @param availableHour
	 */
	public void setAvailableHour(int[][] availableHour) {
		this.availableHour = availableHour;
	}
	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground available hours.
	 * @param i
	 * @param availableHour
	 * @param availableHour2
	 */
	public void setAvailableHour(int i,int availableHour,int availableHour2) {
	this.availableHour[i][0] = availableHour;
	this.availableHour[i][1] = availableHour2;
	}

	
	
	
	
	
	
	/**
	 * This function returns the playground booker ID.
	 * @return
	 */
	public int getBookerID(int i) {
	return bookerID[i];
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground booker ID.
	 * @param bookerID
	 */
	public void setBookerID(int bookerID,int i) {
	this.bookerID[i] = bookerID;
	}

	
	
	
	
	
	
	
	/**
	 * This function returns the playground price.
	 * @return
	 */
	public int getPrice() {
	return price;
	}

	
	
	
	
	
	
	/**
	 * This function sets an initial value to the playground price.
	 * @param price
	 */
	public void setPrice(int price) {
	this.price = price;
	}
	
	
	
	
	
	
	
	/**
	 * This function sets an initial value to the first and last hours of 
	 * the playground available hours for booking.
	 * @param first
	 * @param last
	 */
	public void setHour(int first,int last) {
		for(int i=0;i<24;i++)
		{
			availableHour[i][0] = 0;
			availableHour[i][1] = 0;
		}
		if(first==24)
		{
			availableHour[0][0] = 24;
			availableHour[0][1] = 1;
			first=1;
		}
		for(int i=first;i<24;i++)
		{
			if(i==last)
				break;
			availableHour[i][0] = i;
			availableHour[i][1] = i+1;
		}
	}
	
	
	
	
	
	
	
	/**
	 * This constructor sets initial values to 
	 * the playground name, location, are and price.
	 */
	public Ground() {
		this.groundName = "";
		this.groundLocation = "";
		this.groundArea = 0;
		this.price = 0;
	}
		
	
	
	
	
	
	
	/**
	 * This parameterized constructor sets values using its parameter to 
	 * the playground name, location, area, price and ID.
	 * @param groundName
	 * @param groundLocation
	 * @param groundArea
	 * @param price
	 * @param ID
	 */
	public Ground(String groundName, String groundLocation, float groundArea,int price,int ID) {
		this.groundName = groundName;
		this.groundLocation = groundLocation;
		this.groundArea = groundArea;
		this.price = price;
		this.groundID = ID;
	}
	
	
	
	
	
	
	
	
	/**
	 * This function displays the available hours for booking for the playground.
	 */
	public void displayAvailableHour() {
		
		for(int i=0;i<24;i++)
		{
			if(availableHour[i][0] != 0 && bookerID[i] == -1 &&state.equalsIgnoreCase("active"))
				System.out.print("{" + availableHour[i][0] + "," + availableHour[i][1] + "}");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	/**
	 * This function books the playground using the playground ID and 
	 * the first and last hours of the booking.
	 * @param ID
	 * @param first
	 * @param last
	 * @return
	 */
	public int booking(int ID,int first,int last) {
		
		int total = 0;
		if(first==24){
			
			bookerID[0] = ID;
			first=1;
			total+=price;
		}
		
		for(int i=first;i<24;i++){
			
			if(i==last)
				break;
			bookerID[i] = ID;
			total+=price;
		}
		return total;
	}

	
	
	
	
	
	
	/**
	 * This function displays the booking hours for the playground.
	 */
	public void viewBooking() {
		
		System.out.println(groundName+groundID);
		System.out.print("{begin,last,playerID}");
		
		for(int i=0;i<24;i++)
		{
			if(bookerID[i] != -1 || availableHour[i][0] == 25)
			{
				System.out.print("{" + availableHour[i][0] + "," + availableHour[i][1] + "," + bookerID[i] + "}");
				System.out.println();
			}
		}
		System.out.println("\n\n");
	}

	
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "playground [groundName=" + groundName + ", groundLocation=" + groundLocation + ", groundArea="
				+ groundArea + ", groundID=" + groundID + ", price=" + price +  ", state=" + state + "]";
	}
	
	
}

