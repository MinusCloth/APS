package entidades;

public class Chamados {
	private Pessoa pessoa;
	private int id_chamados,id_pessoa;
	private String descricao;
	private String status;
	private String dt_abertura;
	
	
	
	public String getDt_abertura() {
		return dt_abertura;
	}

	public void setDt_abertura(String dt_abertura) {
		this.dt_abertura = dt_abertura;
	}

	public Chamados(int id_pessoa,String descricao) {	
		super();
		this.id_pessoa=id_pessoa;
		this.descricao = descricao;
		this.status ="Aberto";
	}

	public Chamados() {	
		super();
		this.descricao = descricao;
		this.status ="Aberto";
	}
	
	
	
	
	public int getId_chamados() {
		return id_chamados;
	}




	public void setId_chamados(int id_chamados) {
		this.id_chamados = id_chamados;
	}




	public int getId_pessoa() {
		return id_pessoa;
	}




	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}




	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
	
}
