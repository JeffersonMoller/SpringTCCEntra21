package br.com.amigopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.DadosBancarios;

public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Long> {

}
