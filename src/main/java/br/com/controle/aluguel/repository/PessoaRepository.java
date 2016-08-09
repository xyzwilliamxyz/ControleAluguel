package br.com.controle.aluguel.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.controle.aluguel.model.Pessoa;


public interface PessoaRepository {//extends Repository<Pessoa, Long> {

	List<Pessoa> findAll();
}
