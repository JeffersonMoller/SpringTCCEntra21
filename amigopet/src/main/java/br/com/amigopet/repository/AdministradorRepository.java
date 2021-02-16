package br.com.amigopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
