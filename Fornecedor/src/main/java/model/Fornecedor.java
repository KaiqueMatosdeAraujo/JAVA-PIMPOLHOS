package model;



public class Fornecedor {

	private Integer cod_forcenedor;
	private String  nome_fornecedor;
	/**
	 * @param nome_fornecedor
	 */
	public Fornecedor(String nome_fornecedor) {
		super();
		this.nome_fornecedor = nome_fornecedor;
	}
		
	public Integer getcod_fornecedor() {
		return cod_forcenedor;
	}

	public void setCod_forcenedor(Integer cod_forcenedor) {
		this.cod_forcenedor = cod_forcenedor;
	}

	public String getNome_fornecedor() {
		return nome_fornecedor;
	}

	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}
	
	
}
