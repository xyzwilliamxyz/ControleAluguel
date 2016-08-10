package br.com.controle.aluguel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.aluguel.model.Pessoa;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	List<Pessoa> findAll();
	
	Pessoa save(Pessoa p);
}
