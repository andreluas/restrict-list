package br.com.andreluas.restrictlist.services.validation;

public class CpfMaskValidator {

    public static String maskVerify(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf;
    }
}
