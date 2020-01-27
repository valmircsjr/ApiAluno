package br.com.vcsjr.apiAluno.handler;

public class CamposInvalidosException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CamposInvalidosException(String message) {
        super(message);
    }
}
