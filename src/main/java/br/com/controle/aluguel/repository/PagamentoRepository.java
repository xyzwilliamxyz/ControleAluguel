package br.com.controle.aluguel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.aluguel.model.Pagamento;

@SuppressWarnings("unchecked")
@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
	
	Pagamento save(Pagamento endereco);
	
	List<Pagamento> findAll();
	
	Pagamento findByPagamentoId(Long pagamentoId);
}
