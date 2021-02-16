package br.com.amigopet.controller.form;

import br.com.amigopet.model.Animal;
import br.com.amigopet.repository.AnimalRepository;

public class AtualizacaoAnimalForm {

	private String nome;
	private String tipo;
	private String raca;
	private String idade;
	private String sexo;
	private String descricao;
	private String imagem;
	private int cidade;
	private int estado;
	private String status;
	private String porte;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public Animal atualizar(Long id, AnimalRepository animalRepository) {
		Animal animal = animalRepository.getOne(id);
		animal.setNome(this.nome);
		animal.setTipo(this.tipo);
		animal.setRaca(this.raca);
		animal.setIdade(this.idade);
		animal.setSexo(this.sexo);
		animal.setDescricao(this.descricao);
		animal.setImagem(this.imagem);
		animal.setCidade(this.cidade);
		animal.setEstado(this.estado);
		animal.setStatus(this.status);
		animal.setPorte(this.porte);

		return animal;
	}

}
