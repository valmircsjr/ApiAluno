package br.com.vcsjr.apiAluno.controller;

import java.util.Collection;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vcsjr.apiAluno.handler.AlunoNaoEncontradoException;
import br.com.vcsjr.apiAluno.handler.CamposInvalidosException;
import br.com.vcsjr.apiAluno.model.Aluno;
import br.com.vcsjr.apiAluno.service.AlunoService;

/**
 * Cotroller para API Aluno.
 */
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    AlunoController (final AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * Retorna todos os alunos cadastrados.
     */
    @GetMapping
    public Collection<Aluno> findAll() {
        return alunoService.findAll();
    }

    /**
     * Busca um aluno no banco por meio do ID.
     * @param id ID do aluno.
     * @return ok, se sucesso. Se não, BadRequest.
     */
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Object> findAlunoById(@PathVariable long id){
        Aluno aluno = new Aluno();
        try {
            aluno = alunoService.findById(id);
        }  catch (IllegalArgumentException | NoSuchElementException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(aluno);
    }

    /**
     * Cadastra um aluno no banco.
     * @param aluno Entidade aluno.
     * @return ok, se sucesso. Se não, BadRequest.
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Aluno aluno) {
        Aluno auxAluno = new Aluno();
        try {
            auxAluno = alunoService.createAluno(aluno);
        } catch (CamposInvalidosException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(auxAluno);
    }
    
    /**
     * Atualiza os dados de um aluno. 
     * @param id ID do aluno.
     * @param aluno Entidade Aluno.
     * @return ok, se sucesso. Se não, BadRequest.
     */
    @PutMapping(value="/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") long id, @RequestBody Aluno aluno) {

        try {
            alunoService.updateAluno(id, aluno);
        } catch (AlunoNaoEncontradoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (CamposInvalidosException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body("Aluno Atualizado!");
    }

    /**
     * Deleta um aluno por meio do ID.
     * @param id ID do aluno.
     * @return ok, se sucesso. Se não, BadRequest.
     */
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Object> delete(@PathVariable long id) {
        try {
            alunoService.deleteAluno(id);
        }  catch (IllegalArgumentException | AlunoNaoEncontradoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body("Aluno deletado com sucesso!");
    }
}