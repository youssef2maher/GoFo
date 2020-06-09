package GoFoBackage;

import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This is a welcome phrase
		System.out.println("\t\t\t Welcome to GoFo!!");
		
		//This is a scanner to get input through the console
		Scanner scan = new Scanner(System.in);
		
		
		
		

		/**
		 * Register Section
		 */
		
		Register regist = new Register(); //This an object from Register class
		
		//These are two initial accounts
		regist.signUp("Diab", "Diab@gmail.com", "235711", "Hdayk El-Maady", "0123456789", "owner");
		regist.signUp("Youssef", "Youssef@gmail.com", "131719", "Dar El-Salam", "01113453457", "player");
		////////////////////////////////
		
		
		while (true) {
			
			//To choose between login or sign up
			System.out.print(" 1. Sign up \n 2. Login \n 3. Admin \n -> ");
			int var1 = scan.nextInt();
			
			boolean registerState; //This variable to store the register state if true or false
			
			/*
			 * Sign-up Phase
			 */
			if (var1 == 1) {
				
				System.out.println(" -- Register a New Account -- ");
				
				System.out.print("\t Enter User Name: ");
				String userNameVar = scan.next();
				
				System.out.print("\t Enter Mail: ");
				String mailVar = scan.next();
				
				System.out.print("\t Enter Password: ");
				String passwordVar = scan.next();
				
				System.out.print("\t Enter Address: ");
				String addressVar = scan.next();
				
				System.out.print("\t Enter Mobile Number: ");
				String mobileVar = scan.next();
				
				System.out.print("\t Enter Type (Player or Owner): ");
				String typeVar = scan.next();
				
				registerState = regist.signUp(userNameVar, mailVar, passwordVar, addressVar, mobileVar, typeVar);
				
				//To see check if the account has been signed up or not
				if (registerState) {
					System.out.println(" ** The account has been signed up ** ");
				}else {
					while(!registerState) {
						
						System.out.println(" ** The User Name is already existed ** ");
						
						System.out.print("\t Enter User Name: ");
						userNameVar = scan.next();
						
						registerState = regist.signUp(userNameVar, mailVar, passwordVar, addressVar, mobileVar, typeVar);
					}
					System.out.println(" ** The account has been signed up ** ");
				}
			}
			
			
			
			/*
			 * Login Phase
			 */
			
			String typeVar = " ";	int loginAccID = 0;
			if (var1 != 3) {
				System.out.println(" -- Login with an Existed Account -- ");
				
				//To check if the user is owner or player
				System.out.print(" Enter Accounr Type (Owner or Player): ");
				typeVar = scan.next();
				
				System.out.print("\t Enter User mail: ");
				String userNameVar = scan.next();
				
				System.out.print("\t Enter Password: ");
				String passwordVar = scan.next();
				
				loginAccID = regist.login(userNameVar, passwordVar, typeVar);
				while(loginAccID == -1) {
					System.out.println(" ** Your User Name or Password isn't Correct ** ");
					loginAccID = regist.login(userNameVar, passwordVar, typeVar);
				}
				
				System.out.println(" ** You'er In ** ");
			}
			
			
			
			
			
			
			
			
			
			/**
			 * Playground Owner Main Menu Section
			 */
			
			if (typeVar.equalsIgnoreCase("owner")) {
				
				GroundOwner ownerObj = regist.owner.get(loginAccID);//The user account object
				
				while (true) {
					
					//Displaying the menu for the owner and make him choose an option
					System.out.println("\t\t\t Welcome " + ownerObj.getUserName());
					System.out.print(" [1] Add Playground \n"
									 + " [2] Update Playground \n"
									 + " [3] See Booking Requests \n"
									 + " [4] eWallet \n "
									 + " [5] Log out \n ->");
					int option = scan.nextInt();
					
					
					
					/*
					 * Add Playground Option
					 */
					if (option == 1) {
						
						System.out.println(" -- Add Playground --");
						
						System.out.print("\t Enter Playground Name: ");
						String playgroundNameVar = scan.next();
						
						System.out.print("\t Enter Playground Location: ");
						String playgroundLocationVar = scan.next();
						
						System.out.print("\t Enter Playground Area: ");
						float playgroundAreaVar = scan.nextFloat();
						
						System.out.print("\t Enter Playground Price: ");
						int playgroundPriceVar = scan.nextInt();
						
						ownerObj.addPlayground(playgroundNameVar, playgroundLocationVar, playgroundAreaVar, playgroundPriceVar);
						
					}
					
					
					
					
					/*
					 * Update Playground Option
					 */
					else if (option == 2) {
						
						System.out.println(" -- Update Playground -- ");
						
						//Displaying all the owner playgrounds
						ownerObj.viewPlaygrounds();
						
						System.out.print("\t Enter Playground number: ");
						int playgroundIDVar = scan.nextInt();
						
						while(true) {
							
							System.out.print(" (1) Change Playground Name \n "
												+ " (2) Change Location \n "
												+ " (3) Change Area \n "
												+ " (4) Change Booking Hours \n ");
							int change = scan.nextInt();
							
							String playgroundNameVar = ownerObj.ground.get(playgroundIDVar).getGroundName();
							String playgroundLocationVar = ownerObj.ground.get(playgroundIDVar).getGroundLocation();
							float playgroundAreaVar = ownerObj.ground.get(playgroundIDVar).getGroundArea();
							int startHourVar = 0, endHourVar = 24;
							
							if (change == 1) {
								System.out.print(" Enter the New Playground Name: ");
								playgroundNameVar = scan.next();
								ownerObj.updatePlayground(playgroundIDVar, playgroundNameVar, playgroundLocationVar, playgroundAreaVar, startHourVar, endHourVar,change);
							}
							else if (change == 2) {
								System.out.print(" Enter the New Playground Location: ");
								playgroundLocationVar = scan.next();
								ownerObj.updatePlayground(playgroundIDVar, playgroundNameVar, playgroundLocationVar, playgroundAreaVar, startHourVar, endHourVar,change);
							}
							else if (change == 3) {
								System.out.print(" Enter the New Playground Area: ");
								playgroundAreaVar = scan.nextFloat();
								ownerObj.updatePlayground(playgroundIDVar, playgroundNameVar, playgroundLocationVar, playgroundAreaVar, startHourVar, endHourVar,change);
							}
							else if (change == 4) {
								System.out.print(" Enter the New Playground Area: ");
								startHourVar = scan.nextInt();
								endHourVar = scan.nextInt();
								ownerObj.updatePlayground(playgroundIDVar, playgroundNameVar, playgroundLocationVar, playgroundAreaVar, startHourVar, endHourVar,change);
							}
						}
					}
					
					
					
					
					/*
					 * Booking Requests Option
					 */
					else if (option == 3) {
						
						System.out.println(" -- Booking Requests -- ");
						
						ownerObj.viewBooking();
					}
					
					
					
					
					/*
					 * eWallet Option
					 */
					else if (option == 4) {
						
						System.out.println(" -- eWallet -- ");
						
						while (true) {
							
							System.out.print(" (1) Deposite \n "
											+ " (2) Withdraw \n "
											+ " (3) Balance \n "
											+ " (4) Done! \n -> ");
							int operation = scan.nextInt();
							
							if (operation == 1) {
								
								System.out.print(" Enter the Deposited Value: ");
								int dopsiteValueVar = scan.nextInt();
								
								ownerObj.ewallet.deposit(dopsiteValueVar);
							}
							else if (operation == 2) {
								
								System.out.print(" Enter the Withdrawn Value: ");
								int withdrawValueVar = scan.nextInt();
								
								ownerObj.ewallet.deposit(withdrawValueVar);
							}
							else if (operation == 3) {
								
								System.out.print(" Your Balance: " + ownerObj.ewallet.getBalance());
							}
						}
					}	
					
					
					
					
					/*
					 * Log out Option
					 */
					else if (option == 5) {
						break;
					}
				}
			}
			
			
			
			
			
			
			
			
			/**
			 * Player Main Menu Section
			 */
			
			else if (typeVar.equalsIgnoreCase("player")) {
				
				Player playerObj = regist.player.get(loginAccID);// The Player Account Object
				
				while (true) {
					
					//Displaying the Main Menu to the Player and choose operation to do
					System.out.println("\t\t\t Welcome " + playerObj.getUserName());
					System.out.print(" [1] View Playgrounds \n "
										+ " [2] Book a Playground \n "
										+ " [3] Cancel a Booking \n "
										+ " [4] Add Player to your Team \n "
										+ " [5] Update Team Name"
										+ " [6] View Team \n "
										+ " [7] Log out \n -> ");
					int option = scan.nextInt();
					
					
					
					/*
					 * View Playgrounds Option
					 */
					if (option == 1) {
						
						System.out.println(" -- View Playgrounds -- ");
						
						playerObj.viewPlayground(regist);
					}
					
					
					
					
					/*
					 * Book a Playground Option
					 */
					else if (option == 2) {
						
						System.out.println(" -- Book a Playground -- ");
						playerObj.viewPlayground(regist);
						System.out.print(" Enter Owner ID: ");
						int ownerIDVar = scan.nextInt();
						
						System.out.print(" Enter Playground ID: ");
						int playgourndIDVar = scan.nextInt();
						
						System.out.print(" Enter the Starting Hour: ");
						int firstVar = scan.nextInt();
						
						System.out.print(" Enter the Ending Hour: ");
						int lastVar = scan.nextInt();
						
						int bookingState = playerObj.bookPlayground(regist, ownerIDVar, firstVar, lastVar, playgourndIDVar);
						
						if (bookingState == -2) {
							System.out.println(" ** The Owner ID not Found ** ");
						}
						else if (bookingState == -1) {
							System.out.println(" ** Your Current Balance does't allow the booking ** ");
						}
						else {
							System.out.println(" ** Done!! ** ");
						}	
					}
					
					
					
					
					
					/*
					 * Cancel A Booking Option
					 */
					else if (option == 3) {
						
						System.out.println(" -- Cancel a Booking -- ");
						playerObj.printbooking(regist);
						int ID;
						System.out.println("enter ID of ground you want ");
						ID = scan.nextInt();
						playerObj.cancelPlayground(regist, ID);
					}
					
					
					
					
					
					/*
					 * Add a Player to your Team Option
					 */
					else if (option == 4) {
						
						System.out.println(" -- Add a Player to you Team -- ");
						
						System.out.println(" Enter the Team Mate Name: ");
						String teamMateNameVar = scan.next();
						
						boolean addPlayerState = playerObj.addPlayer(teamMateNameVar, regist);
						if (addPlayerState) {
							System.out.println(" ** Done!! ** ");
						}
						else {
							System.out.println(" ** The Player not Found ** ");
						}
					}
					
					
					
					
					
					/*
					 * Update Team Name Option
					 */
					else if (option == 5) {
						
						System.out.println(" -- Update Team Name -- ");
						
						System.out.print(" Enter the New Team Name: ");
						String newTeamNameVar = scan.next();
						
						playerObj.setTeamName(newTeamNameVar);
						System.out.println(" ** Done!! ** ");
					}
					
					
					
					
					/*
					 * View Team Option
					 */
					else if (option == 6) {
						
						System.out.println(" -- View Team -- ");
										
						System.out.println(playerObj.getTeamName() + " Team");
						
						System.out.println(" Team Members: ");
						for (int i = 0; i < playerObj.getPlayersNumber(); i++) {
							System.out.println(" [" + i+1 + "] " + playerObj.teamPlayers[i]);
						}
					}
					
					
					
					
					/*
					 * Log out Option
					 */
					else if (option == 7) {
						break;
					}
				}	
			}
			
			
			
			
			
			
			
			/**
			 * Admin Main Menu 
			 */
			
			else {
				
				Admin adminObj = regist.admin;
				
				System.out.print(" Enter Admin Name: ");
				String adminNameVar = scan.next();
				
				System.out.print(" Enter Password: ");
				String adminPasswordVar = scan.next();
				
				boolean loginState = adminObj.login(adminNameVar, adminPasswordVar);
				
				if (!loginState) {
					System.out.println(" ** Wrong Name or Password ** ");
				}
				
				while (loginState) {
					
					System.out.println("Welcome Admin");
					System.out.print(" [1] View Activated Playgrounds \n "
										+ " [2] View Non-activated Playgrounds \n "
										+ " [3] View Suspended Playgrounds \n "
										+ " [4] Delete Playground \n "
										+ " [5] Activate Playground \n "
										+ " [6] Suspend Playground \n "
										+ " [7] Log Out \n -> ");
					int option = scan.nextInt();
					
					
					
					
					/*
					 * View Activated Playgrounds Option
					 */
					if (option == 1) {
						
						System.out.println(" -- View Activated Playgrounds -- ");
						
						adminObj.activatedGrounds(regist);
					}
					
					
					
					
					/*
					 * View Non-activated Playgrounds Option
					 */
					else if (option == 2) {
						System.out.println(" -- View Non-activated Playgrounds -- ");
						
						adminObj.nonActivatedGrounds(regist);
					}

					
					
					
					/*
					 * View Suspended Playgrounds Option
					 */
					else if (option == 3) {
						System.out.println(" -- View Suspended Playgrounds -- ");
						
						adminObj.suspendedGrounds(regist);
					}

					
					
					
					/*
					 * Delete Playgrounds Option
					 */
					else if (option == 4) {
						System.out.println(" -- Delete Playground -- ");
						
						System.out.print(" Enter the Playground ID: ");
						int deletedPlaygroundIDVar = scan.nextInt();
						
						adminObj.deleteGround(regist, deletedPlaygroundIDVar);
						System.out.println(" ** Done ** ");
					}								

					
					
					
					/*
					 * Activate Playgrounds Option
					 */
					else if (option == 5) {
						System.out.println(" -- Activate Playground -- ");
						
						System.out.print(" Enter the Playground ID: ");
						int activatedPlaygroundIDVar = scan.nextInt();
						
						adminObj.activateGround(regist, activatedPlaygroundIDVar);
						System.out.println(" ** Done ** ");
					}
					

					
					
					
					/*
					 * Suspend Playgrounds Option
					 */
					else if (option == 6) {
						System.out.println(" -- Suspend Playground -- ");
						
						System.out.print(" Enter the Playground ID: ");
						int suspendedPlaygroundIDVar = scan.nextInt();
						
						adminObj.suspendGround(regist, suspendedPlaygroundIDVar);
						System.out.println(" ** Done ** ");
					}
					
					
					
					
					
					/*
					 * Log Out Option
					 */
					else if (option == 7) {
						break;
					}
				}
			}
		}
	}
}













