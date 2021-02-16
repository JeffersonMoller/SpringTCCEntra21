package br.com.amigopet.dto;

import java.util.List;

import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String celular;
	private List<Animal> animais;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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

	public List<Animal> getAnimais() {
		return animais;
	}
	

}
