package br.com.controle.aluguel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.aluguel.model.Endereco;

@SuppressWarnings("unchecked")
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	
	Endereco save(Endereco endereco);
	
	List<Endereco> findAll();
	
	Endereco findByEnderecoId(Long enderecoId);
}
