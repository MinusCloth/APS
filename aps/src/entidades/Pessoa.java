package entidades;

public class Pessoa {
	private String nome;
	private String email;
	private String rua;
	private String cidade;
	// id_login     id_telefones   id_pessoa
	
	
	
	
	public String  getNome() {
		return this.nome;
	}
	public String getemail() {
		return this.email;
	}
	public String getRua() {
		return this.rua;
	}
	public String getCidade() {
		return this.cidade;
	}
	
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setRua(String rua) {
		this.rua=rua;
	}
	public void setCidade(String cidade) {
		this.cidade=cidade;
	}
	
	public Pessoa(String nome,String email,String rua,String cidade) {
		this.nome=nome;
		this.email=email;
		this.rua=rua;
		this.cidade=cidade;
	}
	

	//metodo cadastrar patrimonio
	
	
	public void criarChamada(String descricao) {
		String desc=descricao;
	}
	
	

}
