package GoFoBackage;

public class Player extends User {
	
	
	/**
	 * @attributes
	 * teamName String
	 * teamPlayers User[]
	 * playerNumberInTeam integer
	 */
	private String teamName = "Team";
	public User teamPlayers[] = new Player[11];
	private int playersNumber = 0;
	
	
	
	/**
	 * This function returns the team name.
	 * @return
	 */
	public String getTeamName(){
	return teamName;
	}
	
	
	
	/**
	 * This function sets the team Name.
	 * @param teamName
	 */
	public void setTeamName(String teamName) {
	this.teamName = teamName;
	}
	
	
	
	/**
	 * This function returns the players number in the team.
	 * @return
	 */
	public int getPlayersNumber() {
	return playersNumber;
	}
	
	
	
	/**
	 * This function returns the players number in the team.
	 * @param playersNumber
	 */
	public void setPlayersNumber(int playersNumber) {
	this.playersNumber = playersNumber;
	}
	
	
	
	/**
	 * This function displays all the approved playgrounds to the player.
	 * @param users
	 */
	public void viewPlayground(Register users) {
		
		for(int i=0;i< users.owner.size(); i++)
		{
			System.out.println(users.owner.get(i).getID());
			users.owner.get(i).viewPlaygrounds();
		}
	}
	
	
	
	/**
	 * This function filters the playground menu to display all the playground 
	 * in order of the player location, or the needed price.
	 * @param users
	 * @param filterBy
	 * @param price
	 */
	public void filter(Register users, String filterBy, int price) {
		
		if (filterBy.equalsIgnoreCase("location")) {
			
			for(int i=0;i< users.owner.size(); i++){
				users.owner.get(i).Filtering(getAddress());
			}
		}
		
		else if(filterBy.equalsIgnoreCase("price")){
			
			for(int i=0;i< users.owner.size(); i++){
				users.owner.get(i).Filtering(price);
			}
		}		
	}
	
	
	
	/**
	 * This function allows the player to a playground using the owner ID, 
	 * then the player determine the first and last hours for his booking.
	 * The function checks if the owner ID is right, then it checks the player
	 * eWallet and see if he is able to pay its cost.
	 * @param users
	 * @param ownerID
	 * @param first
	 * @param last
	 */
	public int bookPlayground(Register users, int ownerID, int first, int last, int groundID) {
		
		int index = 0;
		for(int i = 0; i < users.owner.size(); i++)
		{
			if(users.owner.get(i).getID()== ownerID){
				index = i;
				break;
			}
			index = i + 1;
		}
		if(index == users.owner.size()){
			return -2;
		}
		
		else {
			
			if(users.owner.get(index).checkbooking( first, last, groundID)==true)
			{
				int cost;
				if(first == 24){
					cost = last;
				}
				else {
					cost = last - first;
				}
				
				if(ewallet.withdraw(cost) != -1) {
					return users.owner.get(index).booking(getID(),first,last,cost, groundID);
				}
				else {
					return -1;
				}
			}
			else
			{
				System.out.println("your choose booked hour");
				return -1;
			}
		}
	}
	/**
	 * this function to print booking ground at player 
	 * @param user
	 */
	public void printbooking(Register user)
	{
		for(int i=0;i<user.owner.size();i++)
		{
			for(int j=0;j<user.owner.get(i).ground.size();j++)
			{
				for(int k=0;k<24;k++)
				{
					if(user.owner.get(i).ground.get(j).getBookerID(k)== getID())
						System.out.println(user.owner.get(i).ground.get(j));
				}
			}
		}
	}
	
	/**
	 * 
	 * @param user
	 * @param ID
	 */
	public void cancelPlayground(Register user, int ID) {
		for(int i=0;i<user.owner.size();i++)
		{
			for(int j=0;j<user.owner.get(i).ground.size();j++)
			{
				if(user.owner.get(i).ground.get(j).getGroundID()==ID)
				{	for(int k=0;k<24;k++)
					{
						if(user.owner.get(i).ground.get(j).getBookerID(k)==getID())
						{
							user.owner.get(i).ground.get(j).setBookerID(-1,k);
							if(k==0)
							{
								user.owner.get(i).ground.get(j).setAvailableHour(k, 24, 1);

							}
							else
							{
								user.owner.get(i).ground.get(j).setAvailableHour(k, i+1, i+2);
							}
							ewallet.deposit(user.owner.get(i).ground.get(j).getPrice());
							user.owner.get(i).ewallet.withdraw(user.owner.get(i).ground.get(j).getPrice());
						}
							
					}
				}
			}
		}
		
	}
	
	
	
	/**
	 * This function allows the player to add other players in his team using 
	 * the player user name.
	 * @param playerName
	 * @param users
	 */
	public boolean addPlayer(String playerName, Register users) {
		
		for (int i = 0; i < users.ID; i++) {
			if (users.player.get(i).getUserName().equalsIgnoreCase(playerName)) {
				teamPlayers[playersNumber] = users.player.get(i);
				playersNumber++;
				return true;
			}
		}
		return false;
	}
	
	

	/**
	 * 
	 * @param playerName
	 */
	public void sendInvitation(String playerName) {
		
	}


	
	/**
	 * 
	 */
	public Player() {
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
	public Player(int iD, String userName, String mail, String password, String address, String mobile, String type) {
		super(iD, userName, mail, password, address, mobile, type);
		// TODO Auto-generated constructor stub
	}
	
}
