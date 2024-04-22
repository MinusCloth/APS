package entidades;

public class Patrimonio {
	//id_patrimonio   id_pessoa  
	private double contaCorrente;
	private double contaPoupanca;
	private double outrosInvestimentos;
	
	
	
	public Patrimonio(double contaCorrente, double contaPoupanca, double outrosInvestimentos) {

		this.contaCorrente = contaCorrente;
		this.contaPoupanca = contaPoupanca;
		this.outrosInvestimentos = outrosInvestimentos;
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
	
	

}
