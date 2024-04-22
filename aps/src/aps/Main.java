package aps;

public class Main {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jbdc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
