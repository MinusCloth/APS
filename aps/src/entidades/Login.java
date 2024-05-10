package entidades;

import java.util.ArrayList;
import java.util.List;

public class Login {
	
	private int id_login;
	private String usuario;
	private String senha;
	
	
	
	
	/*public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}*/
	
	private static List<Login> listaLogins = new ArrayList<>();

    public static void adicionarLogin(Login login) {
        listaLogins.add(login);
    }
	
	
	public String getUsuario() {
		return usuario;
	}
	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
