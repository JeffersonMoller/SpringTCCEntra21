package br.com.amigopet.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.amigopet.model.Dica;

public class DicaDto {
	private Long id;
	private String titulo;
	private String descricao;
	private String imagem;

	public DicaDto(Dica dica) {
		this.id = dica.getId();
		this.titulo = dica.getTitulo();
		this.descricao = dica.getDescricao();
		this.imagem = dica.getImagem();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public static List<DicaDto> converterLista(List<Dica> dicas) {
		return dicas.stream().map(DicaDto::new).collect(Collectors.toList());
	}

}
