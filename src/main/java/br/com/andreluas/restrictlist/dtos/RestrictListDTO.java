package br.com.andreluas.restrictlist.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

public class RestrictListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @CPF
    @NotBlank(message = "field cannot be empty")
    private String cpf;
    private Timestamp createdAt;

    public RestrictListDTO() {
    }

    public RestrictListDTO(@CPF @NotBlank(message = "field cannot be empty") String cpf, Timestamp createdAt) {
        this.cpf = cpf;
        this.createdAt = createdAt;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
