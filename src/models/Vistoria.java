package models;

import java.io.Serializable;

public class Vistoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long cpf;
	public String nome;
	public String endereco;
	public String placa;
	public String marca;
	public String observacao;
	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean aprovado;
	
	
	public Vistoria(Long cpf,String nome,String endereco,String placa,String marca,Boolean aprovado,String observacao) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setObservacao(observacao);
		this.setAprovado(aprovado);
	}
	
	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the aprovado
	 */
	public Boolean getAprovado() {
		return aprovado;
	}
	/**
	 * @param aprovado the aprovado to set
	 */
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	
	@Override
	public String toString() {
		return getMarca().concat("-"+getPlaca().concat("-End.:"+getEndereco()));
	}
	
}
