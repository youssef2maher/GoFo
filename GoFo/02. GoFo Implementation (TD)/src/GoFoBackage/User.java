package GoFoBackage;

public class User {

	
	/**
	 * @attributes
	 * ID integer
	 * userName String
	 * mail String
	 * password String
	 * address String
	 * mobile String
	 * type String
	 */
	private int ID;
	private String userName;
	private String mail;
	private String password;
	private String address;
	private String mobile;
	private String type;
	
	public Ewallet ewallet = new Ewallet();
	
	
	/**
	 * This function returns the ID of the user.
	 * @return
	 */
	public int getID() {
		return ID;
	}
	
	
	
	/**
	 * This function sets a value of the ID of the user.
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	/**
	 * This function returns the user name of the user.
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	
	
	/**
	 * This function sets a value of the user name of the user.
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	/**
	 * This function returns the mail of the user.
	 * @return
	 */
	public String getMail() {
		return mail;
	}
	
	
	
	/**
	 * This function sets a value of the mail of the user.
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	/**
	 * This function returns the password of the user.
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	
	
	/**
	 * This function sets a value of the password of the user.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	/**
	 * This function returns the address of the user.
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	
	
	
	/**
	 * This function sets a value of the address of the user.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	/**
	 * This function returns the mobile number of the user.
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	
	
	
	/**
	 * This function sets a value of the mobile number of the user.
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	/**
	 * This function returns the type of the user.
	 * @return
	 */
	public String getType() {
		return type;
	}
	
	
	
	/**
	 * This function sets a value of the type of the user.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	/**
	 * This is a default constructor
	 */
	public User()
	{
		
	}
	
	
	
	/**
	 * This parameterized constructor sets initial values to the info. of the user which is
	 * (ID, user name, mail, password, address, mobile number, type).
	 * @param iD
	 * @param userName
	 * @param mail
	 * @param password
	 * @param address
	 * @param mobile
	 * @param type
	 */
	public User(int iD, String userName, String mail, String password, String address, String mobile, String type) {
		
		ID = iD;
		this.userName = userName;
		this.mail = mail;
		this.password = password;
		this.address = address;
		this.mobile = mobile;
		this.type = type;
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "User [ID=" + ID + ", userName=" + userName + ", mail=" + mail + ", password=" + password + ", address="
				+ address + ", mobile=" + mobile + ", type=" + type + "]";
	}

	
}


