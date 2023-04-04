package br.com.andreluas.restrictlist.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

public class RestrictListInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @CPF
    private String cpf;

    public RestrictListInsertDTO() {
    }

    public RestrictListInsertDTO(@CPF String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
