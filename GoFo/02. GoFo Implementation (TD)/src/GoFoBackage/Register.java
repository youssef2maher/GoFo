package GoFoBackage;

import java.util.ArrayList;

public class Register {
	
	
	/**
	 * @attributes
	 * owner ArrayList<GroundOwner>
	 * player ArrayList<Player>
	 * ID integer
	 * admin Admin
	 */
	public ArrayList<GroundOwner> owner = new ArrayList<GroundOwner>();
	public ArrayList<Player> player = new ArrayList<Player>();
	public int ID = 0;
	
	public Admin admin = new Admin();
	
	
	
	/**
	 * This function allows the user to sign up in the program by creating his profile. 
	 * The function creating a new profile for the user and store his info. which is 
	 * (user name, mail, password, address, mobile number, type).
	 * It checks if the user name entered is unique, and if it is, it returns true, 
	 * otherwise it returns false.
	 * @param name
	 * @param mail
	 * @param password
	 * @param address
	 * @param mobile
	 * @param type
	 * @return
	 */
	public boolean signUp(String name, String mail, String password, String address, String mobile, String type){
		
		try {
			
			for (int i = 0; i < owner.size(); i++) {
				if (owner.get(i).getUserName().equalsIgnoreCase(name)) {
					return false;
				}
			}
			for (int i = 0; i < player.size(); i++) {
				if (player.get(i).getUserName().equalsIgnoreCase(name)) {
					return false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		if(type.equalsIgnoreCase("Owner")){
			GroundOwner newUser = new GroundOwner(ID,name,mail,password,address,mobile,type);
			owner.add(newUser);
			ID++;
		}
		
		else if(type.equalsIgnoreCase("Player")){
			Player newUser = new Player(ID,name,mail,password,address,mobile,type);
			player.add(newUser);
			ID++;
		}
		
		return true;
	}
	
	
	
	/**
	 * This function allows the user to login with his user name and password of 
	 * his account that already have been created. 
	 * The function returns the ID number of the user account, otherwise, 
	 * it returns -1. 
	 * @param mail
	 * @param password
	 * @return
	 */
	public int login(String mail, String password, String type) {
		
		try {
			
			if (type.equalsIgnoreCase("owner")) {
				for (int i = 0; i < owner.size(); i++) {
					if (owner.get(i).getMail().equalsIgnoreCase(mail)&&owner.get(i).getPassword().equalsIgnoreCase(password)) {
						return owner.get(i).getID();
					}
				}
			}
			
			else {
				for (int i = 0; i < player.size(); i++) {
					if (player.get(i).getMail().equalsIgnoreCase(mail)&&player.get(i).getPassword().equalsIgnoreCase(password)) {
						return player.get(i).getID();
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
}
