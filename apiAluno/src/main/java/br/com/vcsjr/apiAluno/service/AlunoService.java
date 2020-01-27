package br.com.vcsjr.apiAluno.service;

import java.util.Collection;

import br.com.vcsjr.apiAluno.model.Aluno;

/**
 * Interface de abstração para os recursos CRUD.
 */
public interface AlunoService {

    /**
     * Cadastra um aluno no banco.
     * @param aluno
     */
    public abstract Aluno createAluno(Aluno aluno);

    /**
     * Atualiza os dados de um aluno.
     * @param id
     * @param aluno
     */
    public abstract void updateAluno(Long id, Aluno aluno);

    /**
     * Deleta um aluno do banco.
     * @param id
     */
    public abstract void deleteAluno(Long id);

    /**
     * Busca um aluno por meio de um ID
     * @param id
     * @return
     */
    public abstract Aluno findById(Long id);

    /**
     * @return Retorna todos os alunos cadastrados.
     */
    public abstract Collection<Aluno> findAll();
}