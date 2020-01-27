package br.com.vcsjr.apiAluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vcsjr.apiAluno.model.Aluno;

/**
 * Repositório para a entidade Aluno.
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}