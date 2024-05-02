package entidades;

public class Pessoa {
	private String nome;
	private String email;
	private String rua;
	private String cidade;
	private int id_login,id_telefones,id_pessoa;
	
	
	
	
	public int getId_login() {
		return id_login;
	}

	public int getId_telefones() {
		return id_telefones;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}
	
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
	
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
	public void setId_telefones(int id_telefones) {
		this.id_telefones = id_telefones;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
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
