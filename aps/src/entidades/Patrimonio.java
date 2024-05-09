package entidades;

public class Patrimonio {
	private Pessoa pessoa;
	private int id_patrimonio,id_pessoa;  
	private double contaCorrente;
	private double contaPoupanca;
	private double outrosInvestimentos;
	
	
	
	public Patrimonio(int id_pessoa,double contaCorrente, double contaPoupanca, double outrosInvestimentos) {
		
		this.id_pessoa=id_pessoa;
		this.contaCorrente = contaCorrente;
		this.contaPoupanca = contaPoupanca;
		this.outrosInvestimentos = outrosInvestimentos;
	}
	
	public Patrimonio(double contaCorrente, double contaPoupanca, double outrosInvestimentos) {

		this.contaCorrente = contaCorrente;
		this.contaPoupanca = contaPoupanca;
		this.outrosInvestimentos = outrosInvestimentos;
	}
	public Patrimonio() {

		this.contaCorrente = contaCorrente;
		this.contaPoupanca = contaPoupanca;
		this.outrosInvestimentos = outrosInvestimentos;
	}
	
	
	
	
	public int getId_patrimonio() {
		return id_patrimonio;
	}



	public void setId_patrimonio(int id_patrimonio) {
		this.id_patrimonio = id_patrimonio;
	}



	public int getId_pessoa() {
		return id_pessoa;
	}



	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}



	public double getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(double contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public double getContaPoupanca() {
		return contaPoupanca;
	}
	public void setContaPoupanca(double contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
	public double getOutrosInvestimentos() {
		return outrosInvestimentos;
	}
	public void setOutrosInvestimentos(double outrosInvestimentos) {
		this.outrosInvestimentos = outrosInvestimentos;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
