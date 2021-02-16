package br.com.amigopet.controller.form;

import br.com.amigopet.model.DadosBancarios;
import br.com.amigopet.repository.DadosBancariosRepository;

public class AtualizacaoDadosBancariosForm {

	private String nomeBanco;
	private String agencia;
	private String conta;
	private String chavePix;

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

	public DadosBancarios atualizar(Long id, DadosBancariosRepository dadosBancariosRepository) {
		DadosBancarios dadosBancarios = dadosBancariosRepository.getOne(id);
		dadosBancarios.setNomeBanco(this.nomeBanco);
		dadosBancarios.setAgencia(this.agencia);
		dadosBancarios.setConta(this.conta);
		dadosBancarios.setChavePix(this.chavePix);

		return dadosBancarios;
	}

}
