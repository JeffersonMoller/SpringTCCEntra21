package br.com.amigopet.controller.form;

import br.com.amigopet.model.Dica;
import br.com.amigopet.repository.DicaRepository;

public class AtualizacaoDicaForm {

	private String titulo;
	private String descricao;
	private String imagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Dica atualizar(Long id, DicaRepository dicaRepository) {
		Dica dica = dicaRepository.getOne(id);
		dica.setTitulo(this.titulo);
		dica.setDescricao(this.descricao);
		dica.setImagem(this.imagem);
		return dica;
	}

}
