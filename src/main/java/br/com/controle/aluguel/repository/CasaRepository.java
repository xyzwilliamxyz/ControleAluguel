package br.com.controle.aluguel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.aluguel.model.Casa;

@Repository
public interface CasaRepository extends CrudRepository<Casa, Long> {

	Casa save(Casa casa);
}
