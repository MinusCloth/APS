package entidades;

public class Telefones {
	private int id_telefones;
	private String telefone1;
	private String telefone2;
	
	
	public Telefones(String telefone1) {
		this.telefone1 = telefone1;
	
	}
	
	
	
	public int getId_telefones() {
		return id_telefones;
	}



	public void setId_telefones(int id_telefones) {
		this.id_telefones = id_telefones;
	}



	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	

}
