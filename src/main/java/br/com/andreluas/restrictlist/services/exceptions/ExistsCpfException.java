package br.com.andreluas.restrictlist.services.exceptions;

public class ExistsCpfException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExistsCpfException(String msg) {
        super(msg);
    }
}
