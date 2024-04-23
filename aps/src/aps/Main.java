package aps;

import DAO.LoginDAO;
import entidades.Login;

public class Main {
	public static void main(String[] args) {
		
		Login l=new Login();
		
		new LoginDAO().autenticacaoUsuario(l);
		
		
	}
}
