package br.com.amigopet.dto;

import br.com.amigopet.model.Usuario;

public class UsuarioComSenhaDto {
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String celular;

	public UsuarioComSenhaDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.celular = usuario.getCelular();

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}

	public String getSenha() {
		return senha;
	}

}
