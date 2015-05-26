package modelo;

public class Pessoa {

	protected String nome;
	protected long cpf;
	protected String sexo;
	protected long telefone;
	protected String endereco;

	// CONTRUTOR PADRÃO
	public Pessoa() {

	}

	// CONSTRUTOR SOBRECARREGADO
	public Pessoa(String pNome, long pCpf, String pSexo, long pTelefone, String pEndereco) {
		this.nome = pNome;
		this.cpf = pCpf;
		this.sexo = pSexo;
		this.telefone = pTelefone;
		this.endereco = pEndereco;
	}

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public long getCpf() {
		return cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public long getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNome(String pNome) {
		this.nome = pNome;
	}

	public void setCpf(long pCpf) {
		this.cpf = pCpf;
	}

	public void setSexo(String pSexo) {
		this.sexo = pSexo;
	}

	public void setTelefone(long pTelefone) {
		this.telefone = pTelefone;
	}

	public void setEndereco(String pEndereco) {
		this.endereco = pEndereco;
	}

	// TOSTRING
	public String toString() {
		return "\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nSexo: "
				+ getSexo() + "\nTelefone: " + getTelefone() + "\nEndereço: "
				+ getEndereco();
	}

}