package model;

public class Professor {

	private String nomeProfessor;
	private String cpf;
	private String areaInteresse;
	private int quantidadePontos;
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAreaInteresse() {
		return areaInteresse;
	}
	public void setAreaInteresse(String areaInteresse) {
		this.areaInteresse = areaInteresse;
	}
	public int getQuantidadePontos() {
		return quantidadePontos;
	}
	public void setQuantidadePontos(int quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}
	@Override
	public String toString() {
		return nomeProfessor + ";" + cpf + ";" + areaInteresse
				+ ";" + quantidadePontos;
	}
	
}
