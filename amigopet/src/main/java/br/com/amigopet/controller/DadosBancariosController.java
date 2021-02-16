package br.com.amigopet.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amigopet.controller.form.AtualizacaoDadosBancariosForm;

import br.com.amigopet.dto.DadosBancariosDto;

import br.com.amigopet.model.DadosBancarios;

import br.com.amigopet.repository.DadosBancariosRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/dadosbancarios")
public class DadosBancariosController {

	@Autowired
	DadosBancariosRepository dadosBancariosRepository;

	@PostMapping("/cadastrar")
	public DadosBancarios cadastrar(@RequestBody DadosBancarios dadosBancarios) {
		return dadosBancariosRepository.save(dadosBancarios);
	}

	@GetMapping("/visualizar/{id}")
	@Transactional
	public DadosBancariosDto visualizar(@PathVariable Long id) {
		DadosBancarios dadosBancarios = dadosBancariosRepository.getOne(id);
		return new DadosBancariosDto(dadosBancarios);
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<DadosBancariosDto> alterar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoDadosBancariosForm form) {
		DadosBancarios dadosBancarios = form.atualizar(id, dadosBancariosRepository);
		return ResponseEntity.ok(new DadosBancariosDto(dadosBancarios));
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		dadosBancariosRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
