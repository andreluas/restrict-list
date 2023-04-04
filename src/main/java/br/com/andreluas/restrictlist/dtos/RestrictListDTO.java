package br.com.andreluas.restrictlist.dtos;

import java.io.Serializable;
import java.time.Instant;

import org.hibernate.validator.constraints.br.CPF;

public class RestrictListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @CPF
    private String cpf;
    private Instant createdAt;

    public RestrictListDTO() {
    }

    public RestrictListDTO(@CPF String cpf, Instant createdAt) {
        this.cpf = cpf;
        this.createdAt = createdAt;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
