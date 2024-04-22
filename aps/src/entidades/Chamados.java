package entidades;

public class Chamados {
	//id_chamados   id_pessoa
	private String descricao;
	private String status;
	
	public Chamados(String descricao, String status) {
		super();
		this.descricao = descricao;
		this.status = status;
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
	
	
	
	
	
	
}
