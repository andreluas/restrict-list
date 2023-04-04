package br.com.andreluas.restrictlist.services.exceptions;

public class NotFoundCpfException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundCpfException(String msg) {
        super(msg);
    }
}
