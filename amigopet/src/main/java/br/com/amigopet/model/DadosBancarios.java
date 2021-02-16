package br.com.amigopet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DadosBancarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeBanco;
	private String agencia;
	private String conta;
	private String chavePix;
	@ManyToOne
	private Usuario usuario;

	public DadosBancarios() {
	}

	public DadosBancarios(String nomeBanco, String agencia, String conta, String chavePix, Usuario usuario) {
		super();
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.conta = conta;
		this.chavePix = chavePix;
		this.usuario = usuario;
	}

	public DadosBancarios(Long id, String nomeBanco, String agencia, String conta, String chavePix) {
		super();
		this.id = id;
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.conta = conta;
		this.chavePix = chavePix;

	}

	public DadosBancarios(Long id, String nomeBanco, String agencia, String conta, String chavePix, Usuario usuario) {
		super();
		this.id = id;
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.conta = conta;
		this.chavePix = chavePix;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
