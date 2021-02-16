package br.com.amigopet.controller;



import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.amigopet.config.security.TokenService;
import br.com.amigopet.controller.form.AtualizacaoUsuarioForm;
import br.com.amigopet.dto.TokenDto;

import br.com.amigopet.dto.UsuarioDto;

import br.com.amigopet.model.Usuario;
import br.com.amigopet.repository.AnimalRepository;
import br.com.amigopet.repository.UsuarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid Usuario usuario) {
		boolean existeEmail = usuarioRepository.existsByEmail(usuario.getEmail());;
		if(!existeEmail) {
			usuarioRepository.save(usuario);
			return ResponseEntity.ok(usuario);
		} else {
			 return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/visualizar/{id}")
	@Transactional
	public UsuarioDto visualizar(@PathVariable Long id) {
		Usuario usuario = usuarioRepository.getOne(id);
		return new UsuarioDto(usuario);
	}
	


	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<TokenDto> alterar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoUsuarioForm form) {
		
		form.atualizar(id, usuarioRepository);
		
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
		
	
	}

}
