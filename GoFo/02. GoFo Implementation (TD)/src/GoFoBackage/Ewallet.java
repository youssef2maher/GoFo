package GoFoBackage;

public class Ewallet {
	
	/**
	 * @attributes
	 * balance integer
	 */
	private int balance;

	
	
	/**
	 * This function returns the balance value;
	 * @return
	 */
	public int getBalance() {
		return balance;
	}

	
	
	/**
	 * This function sets a value to the balance
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	/**
	 * This function allows the user to withdraw cash from his eWallet.
	 * The function returns the withdrawing money if the user account 
	 * has enough money, otherwise, it returns -1.
	 * @param valueWithdraw
	 * @return
	 */
	public int withdraw(int valueWithdraw) {
		
		if(valueWithdraw <= balance){
			balance -= valueWithdraw;
			return valueWithdraw;
		}
		
		else{
			return -1;
		}
	}
	
	
	
	/**
	 * This function adds cash to the user eWallet.
	 * @param valueDeposit
	 */
	public void deposit (int valueDeposit) {
		balance += valueDeposit;
	}
	
	
	
	/**
	 * This constructor sets an initial value to the user balance
	 * in his eWallet.
	 */
	public Ewallet() {
		this.balance = 1000;
	}
	
	
	
	/**
	 * This parameterized constructor sets a value to the user 
	 * balance in his eWallet.
	 * @param balance
	 */
	public Ewallet(int balance) {
		this.balance = balance;
	}
}