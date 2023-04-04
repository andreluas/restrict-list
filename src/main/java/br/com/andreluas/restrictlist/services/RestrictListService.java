package br.com.andreluas.restrictlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andreluas.restrictlist.dtos.RestrictListDTO;
import br.com.andreluas.restrictlist.dtos.RestrictListInsertDTO;
import br.com.andreluas.restrictlist.mappers.RestrictListMapper;
import br.com.andreluas.restrictlist.models.RestrictList;
import br.com.andreluas.restrictlist.repositories.RestrictListRepository;
import br.com.andreluas.restrictlist.services.exceptions.ExistsCpfException;
import br.com.andreluas.restrictlist.services.exceptions.NotFoundCpfException;
import br.com.andreluas.restrictlist.services.validation.CpfMaskValidator;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RestrictListService {

    @Autowired
    private RestrictListRepository repository;

    @Autowired
    private RestrictListMapper mapper;

    public RestrictListInsertDTO addCpf(RestrictListInsertDTO dto) {
        RestrictList entity = mapper.dtoToEntity(dto);
        entity.setCpf(CpfMaskValidator.maskVerify(entity.getCpf()));
        Optional<RestrictList> checkCPF = repository.findByCpf(entity.getCpf());
        if (checkCPF.isPresent()) {
            throw new ExistsCpfException("CPF already existing in database.");
        }
        repository.save(entity);
        return mapper.entityToInsertDTO(entity);
    }

    public RestrictListDTO checkCpf(String cpf) {
        Optional<RestrictList> obj = repository.findByCpf(cpf);
        RestrictList entity = obj.orElseThrow(() -> new NotFoundCpfException("CPF not found."));
        return mapper.entityToDTO(entity);
    }

    public void removeCpf(String cpf) {
        try {
            Optional<RestrictList> obj = repository.findByCpf(cpf);
            RestrictList entity = obj.orElseThrow(() -> new NotFoundCpfException("CPF not found."));
            repository.deleteById(entity.getId());
        } catch (RuntimeException e) {
            throw new NotFoundCpfException("CPF not found.");
        }
    }

    public List<RestrictListDTO> findAllCpf() {
        List<RestrictList> list = repository.findAll();
        return mapper.entityListToDtoList(list);
    }
}
