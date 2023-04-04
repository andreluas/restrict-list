package br.com.andreluas.restrictlist.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import br.com.andreluas.restrictlist.controllers.exceptions.FieldMessage;
import br.com.andreluas.restrictlist.dtos.RestrictListInsertDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfInsertValidator implements ConstraintValidator<CPF, RestrictListInsertDTO> {

    @Override
    public void initialize(CPF ann) {
    }

    public boolean isValid(RestrictListInsertDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (!CpfValidator.isCpf(dto.getCpf())) {
            list.add(new FieldMessage("InvalidCpfException", "CPF not valid."));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getType())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
