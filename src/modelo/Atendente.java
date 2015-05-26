package modelo;

public class Atendente extends Pessoa {
	//ATRIBUTOS
	protected static int idAtendimentoGeral;
	protected int idAtendente;
	protected String funcao;

	// CONSTRUTOR PADRÃO
	public Atendente() {
		idAtendimentoGeral += +1;
		idAtendente = idAtendimentoGeral;

	}

	// CONSTRUTOR SOBRECARREGADO
	public Atendente(int id, String funcao) {
		this.idAtendente = id;
		this.funcao = funcao;
	}

	// GETTERES E SETTERS
	
	public static int getIdAtendimentoGeral(){
		return idAtendimentoGeral;
		
	}
	
	public static void setIdAtendimentoGeral(int pIdAtendimentoGeral){
		Atendente.idAtendimentoGeral = pIdAtendimentoGeral;
	}
	
	public long getIdAtendente() {
		return idAtendente;
	}

	public void setIdAtendente(int id) {
		this.idAtendente = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	// TOSTRING
	public String toString() {
		return super.getNome() +" Cod.: " + getIdAtendente()+"\n\n";
	}

	
	
	/*
	 * este metodo foi para no caso de comparação de objeto, o java compara os
	 * objetos.
	 */
	public boolean equals(Object obj) {
		Atendente funcionario = (Atendente) obj;
		if (funcionario.getNome() == this.nome)
			return true;
		return false;
	}
	
}