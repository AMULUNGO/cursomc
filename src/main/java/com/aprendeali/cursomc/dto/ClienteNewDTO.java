package com.aprendeali.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/*
 * Esta Classe ClienteNewDTO e usada para inserir um cliente junto com o seu endereco.
 * O endereco tambem possue uma cidade
 * 
 * */
import org.hibernate.validator.constraints.Length;

import com.aprendeali.cursomc.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Campo Obrigatorio")
	@Length(min = 5, max = 120, message = "O nome deve ter entre 5 a 120 caracteres")
	private String nome;

	@NotEmpty(message = "Campo Obrigatorio")
	@Email(message = "Email Invalido")
	private String email;

	private String nuit;
	private Integer tipoCliente;

	@NotEmpty(message = "Campo Obrigatorio")
	private String logradouro;
	private String numero;
	private String complemento;

	@NotEmpty(message = "Campo Obrigatorio")
	private String bairro;

	@NotEmpty(message = "Campo Obrigatorio")
	private String quarteirao;

	@NotEmpty(message = "Campo Obrigatorio")
	private String telefone1;

	private String telefone2;
	private String telefone3;

	private Integer cidadeId;

	public ClienteNewDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNuit() {
		return nuit;
	}

	public void setNuit(String nuit) {
		this.nuit = nuit;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getQuarteirao() {
		return quarteirao;
	}

	public void setQuarteirao(String quarteirao) {
		this.quarteirao = quarteirao;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

}
