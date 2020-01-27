package br.com.vcsjr.apiAluno.handler;

/**
 * Exceção para aluno nao encontrado na base de dados.
 */
public class AlunoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontradoException(String message) {
        super(message);
    }

}
