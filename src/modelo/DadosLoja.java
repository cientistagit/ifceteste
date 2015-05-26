package modelo;

public class DadosLoja {

	protected String idLoja;
	protected String nomeEmpresarial;
	protected String nomeFantasia;
	protected long cnpj;
	protected String enderecoLoja; 
	protected long telefoneLoja; 
	
	//Construtor padrão
	public DadosLoja(){
			
	}
	
	//Construtor parametrizado sobrecarregado
	public DadosLoja(String idLoja, String nomeEmpresarial, String nomeFantasia, long cnpj, String enderecoLoja, long telefoneLoja){
		this.idLoja=idLoja;
		this.nomeEmpresarial=nomeEmpresarial;
		this.nomeFantasia=nomeFantasia;
		this.cnpj=cnpj;
		this.enderecoLoja=enderecoLoja;
		this.telefoneLoja=telefoneLoja;
	}
	//Getters e Setters
	public String getIdLoja(){
		return idLoja;
	}
	public String getNomeEmpresarial(){
		return nomeEmpresarial;
	}
	public String getNomeFantasia(){
		return nomeFantasia;
	}
	public long getCnpj(){
		return cnpj;
	}
		
	public String getEnderecoLoja(){
		return enderecoLoja;
	}
	public long getTelefoneLoja(){
		return telefoneLoja;
	}
	
	public void setIdLoja(String idLoja){
		this.idLoja=idLoja;
	}
	public void setNomeEmpresarial(String nomeEmpresarial){
		this.nomeEmpresarial=nomeEmpresarial;
	}
	public void setNomeFantasia(String nomeFantasia){
		this.nomeFantasia=nomeFantasia;
	}
	public void setCnpj(long cnpj){
		this.cnpj=cnpj;
	}
		
	public void setEnderecoLoja(String enderecoLoja){
		this.enderecoLoja=enderecoLoja;
	}
	public void setTelefoneLoja(long telefoneLoja){
		this.telefoneLoja=telefoneLoja;
	}
	
	//toString
	public String toString(){
		return "ID da Empresa: " + idLoja + "\n Nome da Empresa: " + nomeEmpresarial + "\n Nome Fantasia: " + nomeFantasia + "\n CNPJ: " + cnpj + "\n Endereço da Empresa: " + enderecoLoja + "\n Telefone: " + telefoneLoja;
	}
}
