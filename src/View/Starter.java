package View;


import Controller.DBWrapper;

public class Starter {

	
	public static void main(String[] args) 
	{
		DBWrapper db= new DBWrapper();
		db.createTables();
		ServerGUI ser= new ServerGUI(1500);
		ser.setVisible(true);
		
		
		LogIn log= new LogIn();
		log.setVisible(true);
		
//		System.out.println("Come on");
	
	}
	





}
