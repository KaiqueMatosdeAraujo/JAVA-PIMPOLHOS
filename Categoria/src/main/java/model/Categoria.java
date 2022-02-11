package model;

public class Categoria {
	private Integer cod_categoria;
	private String  nome_categoria;
	/**
	 * @param nome_categoria
	 */
	public Categoria( String nome_categoria) {
		super();
		this.nome_categoria = nome_categoria;
	}
	public Integer getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(Integer cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	public String getNome_categoria() {
		return nome_categoria;
	}
	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}
	
}
