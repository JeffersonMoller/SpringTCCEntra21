package br.com.amigopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amigopet.model.Animal;
import br.com.amigopet.model.Usuario;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


	List<Animal> findAllByUsuario(Usuario usuario);

}
