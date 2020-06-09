package GoFoBackage;

public class Admin {
	
private String adminName = "Amir";
private String password = "321";


	/**
	 * This function returns the admin name 
	 * @return
	 */
	public String getAdminNAme() {
	return adminName;
	}
	
	
	
	
	
	
	
	/**
	 * This function sets a value to the admin name
	 * @param adminName
	 */
	public void setAdminName(String adminName) {
	this.adminName = adminName;
	}
	
	
	
	
	
	
	/**
	 * This function returns the admin password
	 * @return
	 */
	public String getPassword() {
	return password;
	}
	
	
	
	
	
	
	/**
	 * This function sets a value to the admin password
	 * @param password
	 */
	public void setPassword(String password) {
	this.password = password;
	}
	
	
	
	
	
	
	/**
	 * This is a default constructor
	 */
	Admin()
	{
		
	}
	
	
	
	
	
	
	/**
	 * This function login the admin into the system
	 * @param name
	 * @param pass
	 * @return
	 */
	public boolean login(String name, String pass) {
		
		if (name.equals(adminName) && pass.equals(password)) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	/**
	 * This function deletes a playground
	 * @param user
	 * @param id
	 */
	public void deleteGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.remove(j);
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * This function activates a playground
	 * @param user
	 * @param id
	 */
	public void activateGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("Active");
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * This function suspends a playground
	 * @param user
	 * @param id
	 */
	public void suspendGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("not");
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * This function approves a playground
	 * @param user
	 * @param id
	 */
	public void approveGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("Active");
			}
		}
	}
	
	
	
	
	
	
	/**
	 * This function displays the activated playgrounds
	 * @param user
	 */
	public void activatedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "Active")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * This function displays the non-activated playgrounds
	 * @param user
	 */
	public void nonActivatedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "notActive")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * This function displays the suspended playgrounds
	 * @param user
	 */
	public void suspendedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "Suspend")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
}


