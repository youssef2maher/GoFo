package GoFoBackage;

public class Admin {
	
private String adminName = "Alamir";
private String password = "321";


	
	public String getAdminNAme() {
	return adminName;
	}
	
	
	public void setAdminName(String adminName) {
	this.adminName = adminName;
	}
	
	
	public String getPassword() {
	return password;
	}
	
	
	public void setPassword(String password) {
	this.password = password;
	}
	

	Admin(){}
	
	
	public boolean login(String name, String pass) {
		
		if (name.equals(adminName) && pass.equals(password)) {
			return true;
		}
		return false;
	}
	
	
	
	public void deleteGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.remove(j);
			}
		}
	}
	
	
	
	public void activateGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("Active");
			}
		}
	}
	
	
	
	public void suspendGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("not");
			}
		}
	}
	
	
	
	public void approveGround(Register user, int id) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getGroundID() == id)
					user.owner.get(i).ground.get(j).setState("Active");
			}
		}
	}
	
	
	
	public void activatedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "Active")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
	
	
	
	public void nonActivatedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "notActive")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
	
	
	
	public void suspendedGrounds(Register user) {
		for(int i = 0; i < user.owner.size(); i++) {
			for(int j = 0; j < user.owner.get(i).ground.size(); j++) {
				if(user.owner.get(i).ground.get(j).getState() == "Suspend")
					System.out.println(user.owner.get(i).ground.get(j));
			}
		}
	}
}