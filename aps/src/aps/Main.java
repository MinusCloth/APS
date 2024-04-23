package aps;

import DAO.LoginDAO;
import entidades.Login;

public class Main {
	public static void main(String[] args) {
		
		Login l=new Login("Carlos","12345");
		
		new LoginDAO().cadastrarUsuario(l);
		
		
	}
}
