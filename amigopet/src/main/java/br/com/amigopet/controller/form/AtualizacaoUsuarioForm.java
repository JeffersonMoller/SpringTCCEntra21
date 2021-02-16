package br.com.amigopet.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	private String nome;
	private String email;
	private String senha;
	private String celular;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		boolean existeEmail = usuarioRepository.existsByEmail(this.email);
		String mensagem = "";

		if(usuario.getEmail().equals(this.email)) {
			usuario.setNome(this.nome);
			usuario.setSenha(this.senha);
			usuario.setCelular(this.celular);
			mensagem = "alterado com sucesso";
		} else if(existeEmail) {
			usuario.setNome(this.nome);
			usuario.setSenha(this.senha);
			usuario.setCelular(this.celular);
			mensagem = "o email ja existente no banco";
		} else {
			usuario.setNome(this.nome);
			usuario.setEmail(this.email);
			usuario.setSenha(this.senha);
			usuario.setCelular(this.celular);
			mensagem = "não é igual o seu e não tem no banco";
		}
		return mensagem;

	}
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
	

}
