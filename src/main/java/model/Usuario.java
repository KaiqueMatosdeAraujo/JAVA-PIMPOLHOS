package model;

import java.util.Date;

public class Usuario {

	private Integer cod_cliente;
	private String  nome;
	private String  cpf;
	private Date  nascimento;
	private String  email;
	private String  senha;
	
	
	public Usuario(String nome, String cpf,Date nascimento ,String email, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.senha = senha;
	}


	public Integer getCod_cliente() {
		return cod_cliente;
	}


	public void setCod_cliente(Integer id) {
		this.cod_cliente = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	public String toString() {
		return this.cod_cliente+ " - " + this.nome + " - " + this.cpf + " - " + this.email + " - " + this.senha;
	}
	
}
