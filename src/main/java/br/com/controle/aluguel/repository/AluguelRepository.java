package br.com.controle.aluguel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.aluguel.model.Aluguel;

@SuppressWarnings("unchecked")
@Repository
public interface AluguelRepository extends CrudRepository<Aluguel, Long> {
	
	Aluguel save(Aluguel aluguel);
	
	List<Aluguel> findAll();
	
	Aluguel findByAluguelId(Long aluguelId);
}
