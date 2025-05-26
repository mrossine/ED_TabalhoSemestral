package model;

public class Disciplina {

	private String idDisciplina;
	private String nome;
	private String diaSemanaDisciplina;
	private String horaInicialDisciplina;
	private	String quantidadeHorasDias;
	private String idCurso;
	
	public String getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(String idDisciplina) {
		this.idDisciplina = idDisciplina; 
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiaSemanaDisciplina() {
		return diaSemanaDisciplina;
	}
	public void setDiaSemanaDisciplina(String diaSemanaDisciplina) {
		this.diaSemanaDisciplina = diaSemanaDisciplina;
	}
	public String getHoraInicialDisciplina() {
		return horaInicialDisciplina;
	}
	public void setHoraInicialDisciplina(String horaInicialDisciplina) {
		this.horaInicialDisciplina = horaInicialDisciplina;
	}
	public String getQuantidadeHorasDias() {
		return quantidadeHorasDias;
	}
	public void setQuantidadeHorasDias(String quantidadeHorasDias) {
		this.quantidadeHorasDias = quantidadeHorasDias;
	}
	public String getCodigoCurso() {
		return idCurso;
	}
	public void setCodigoCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	@Override
	public String toString() {
		return idDisciplina + ";" + nome + ";"
				+ diaSemanaDisciplina + ";" + horaInicialDisciplina + ";"
				+ quantidadeHorasDias + ";" + idCurso;
	}
	
}
