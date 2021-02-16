package br.com.amigopet.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.amigopet.controller.form.AtualizacaoDicaForm;
import br.com.amigopet.dto.DicaDto;

import br.com.amigopet.model.Dica;

import br.com.amigopet.repository.DicaRepository;

import br.com.amigopet.server.DataDica;

@CrossOrigin("*")
@RestController
@RequestMapping("/dica")
public class DicaController {

	@Autowired
	DicaRepository dicaRepository;

	@Autowired
	DataDica dataServer;

	@PostMapping("/cadastrar")
	public Dica cadastrar(@RequestBody Dica dica) {
		return dicaRepository.save(dica);
	}

	@PostMapping("/cadastrarfoto/{idDica}")
	public void cadastrar(@Valid @PathVariable("idDica") Long idDica,
			@RequestPart(name = "imagem") MultipartFile imagem) throws Exception {

		Dica dica = criaHashImagem(idDica, imagem);

		dataServer.criaDiretorio(imagem, dica);

		dicaRepository.save(dica);

	}

	@GetMapping("/visualizar/{id}")
	@Transactional
	public DicaDto visualizar(@PathVariable Long id) {
		Dica dica = dicaRepository.getOne(id);
		return new DicaDto(dica);
	}

	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<DicaDto> altera(@PathVariable Long id, @RequestBody @Valid AtualizacaoDicaForm form) {
		Dica dica = form.atualizar(id, dicaRepository);
		return ResponseEntity.ok(new DicaDto(dica));
	}

	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		dicaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/lista")
	public List<DicaDto> lista() {
		List<Dica> dicas = dicaRepository.findAll();
		return DicaDto.converterLista(dicas);
	}

	private Dica criaHashImagem(@Valid Long idDica, MultipartFile imagem) throws Exception {
		Dica dica = dicaRepository.findById(idDica).orElseThrow(() -> new Exception("Dica não encontrada"));
		String nome = imagem.getOriginalFilename().substring(0, imagem.getOriginalFilename().length() - 4);
		String ext = imagem.getOriginalFilename().substring(imagem.getOriginalFilename().length() - 4,
				imagem.getOriginalFilename().length());
		String imgHashSave = nome + '_' + System.currentTimeMillis() + ext;

		dica.setImagem(imgHashSave);

		return dica;
	}
}
