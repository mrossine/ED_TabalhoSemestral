package model;

public class Curso {

	private String idCurso;
	private String nomeCurso;
	private String areaConhecimento;
	
	public String getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getAreaConhecimento() {
		return areaConhecimento;
	}
	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	@Override
	public String toString() {
		return idCurso + ";" + nomeCurso + ";" + areaConhecimento;
	}
	
}
