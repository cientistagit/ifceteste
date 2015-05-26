package modelo;

public class Cliente extends Pessoa {
	protected static int idClienteGeral;
	protected int idCliente;
	protected String tipoCliente;

	// CONTRUTOR PADRÃO
	public Cliente() {
		idClienteGeral += 1;
		idCliente = idClienteGeral;

	}

	// CONSTRUTOR SOBRECARREGADO
	public Cliente(int pIdCliente, String pTipoCliente) {
		this.idCliente = pIdCliente;
		this.tipoCliente = pTipoCliente;
	}

	// GETTERS E SETTERS
	public static int getIdClienteGeral() {
		return idClienteGeral;
	}

	public static void setIdClienteGeral(int pIdClienteGeral) {
		Cliente.idClienteGeral = pIdClienteGeral;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id) {
		this.idCliente = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String PTipoCliente) {
		this.tipoCliente = PTipoCliente;
	}

	// TOSTRING
	public String toString() {
		return super.getNome() +" CPF: "+super.getCpf();
	}
	
	
	/*// TOSTRING
	public String toString() {
		return super.toString() + "\nTipo Cliente: " + getTipoCliente()
				+ "\nID do Cliente: " + getIdCliente();
	}*/
	
	

	/*
	 * este metodo foi para no caso de comparação de objeto, o java compara os
	 * objetos.
	 */
	public boolean equals(Object obj) {
		Cliente cliente = (Cliente) obj;
		if (cliente.getNome() == nome)
			return true;
		return false;
	}

}