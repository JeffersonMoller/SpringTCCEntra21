package br.com.amigopet.dto;


import br.com.amigopet.model.DadosBancarios;

public class DadosBancariosDto {
	private Long id;
	private String nomeBanco;
	private String agencia;
	private String conta;
	private String chavePix;
	private Long usuario;

	

	public DadosBancariosDto(DadosBancarios dadosBancarios) {
		this.id = dadosBancarios.getId();
		this.nomeBanco = dadosBancarios.getNomeBanco();
		this.agencia = dadosBancarios.getAgencia();
		this.conta = dadosBancarios.getConta();
		this.chavePix = dadosBancarios.getChavePix();
		this.usuario = dadosBancarios.getUsuario().getId();
	}

	public Long getId() {
		return id;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getConta() {
		return conta;
	}

	public String getChavePix() {
		return chavePix;
	}

	public Long getUsuario() {
		return usuario;
	}
	
	

//	public static DadosBancariosDto converter(Optional<DadosBancarios> dadosBancarios) {
//		DadosBancariosDto dadosBancariosDto = new DadosBancariosDto(dadosBancarios.get().getId(),
//				dadosBancarios.get().getNomeBanco(), dadosBancarios.get().getAgencia(), dadosBancarios.get().getConta(),
//				dadosBancarios.get().getChavePix());
//		return dadosBancariosDto;
//	}

}
