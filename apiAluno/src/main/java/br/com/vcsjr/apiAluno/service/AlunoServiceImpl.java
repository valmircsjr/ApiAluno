package br.com.vcsjr.apiAluno.service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import br.com.vcsjr.apiAluno.handler.AlunoNaoEncontradoException;
import br.com.vcsjr.apiAluno.handler.CamposInvalidosException;
import br.com.vcsjr.apiAluno.model.Aluno;
import br.com.vcsjr.apiAluno.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno createAluno(Aluno aluno) {
        Aluno auxAluno = new Aluno();
        try {
            auxAluno = alunoRepository.save(aluno);
        } catch (ConstraintViolationException | TransactionSystemException | RollbackException ex) {
            throw new CamposInvalidosException("Campos invalidos!");
        }
        return auxAluno; 
    }

    @Override
    public void updateAluno(Long id, Aluno aluno) {

        try {
            if (alunoRepository.existsById(id)) {
                alunoRepository.deleteById(id);
                aluno.setId(id);
                alunoRepository.save(aluno);
            } else {
                throw new AlunoNaoEncontradoException("Não há aluno com o ID informado!");
            }
        } catch (ConstraintViolationException | TransactionSystemException | RollbackException ex) {
            throw new CamposInvalidosException("Campos invalidos!");
        }
    }

    @Override
    public void deleteAluno(Long id) {
        try {
            alunoRepository.deleteById(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException ("Valor do Id nulo!");
        } catch (EmptyResultDataAccessException ex) {
            throw new AlunoNaoEncontradoException("Não há aluno com o ID informado!");
        }
    }

    @Override
    public Aluno findById(Long id) {

        Optional<Aluno> alunoOptional = Optional.empty();
        Aluno aluno = new Aluno();

        try {
            alunoOptional = alunoRepository.findById(id);
            aluno = alunoOptional.get();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException ("Valor do Id nulo!");
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("Aluno nao encontrado!");
        }
        return aluno;
    }

    @Override
    public Collection<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}