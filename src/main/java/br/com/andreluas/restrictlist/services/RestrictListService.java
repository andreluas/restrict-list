package br.com.andreluas.restrictlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.andreluas.restrictlist.dtos.RestrictListDTO;
import br.com.andreluas.restrictlist.dtos.RestrictListInsertDTO;
import br.com.andreluas.restrictlist.mappers.RestrictListMapper;
import br.com.andreluas.restrictlist.models.RestrictList;
import br.com.andreluas.restrictlist.repositories.RestrictListRepository;
import br.com.andreluas.restrictlist.services.exceptions.GenericException;
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
        repository.save(entity);
        return mapper.entityToInsertDTO(entity);
    }

    public RestrictListDTO checkCpf(String cpf) {
        Optional<RestrictList> obj = repository.findByCpf(cpf);
        RestrictList entity = obj.orElseThrow(() -> new GenericException("Exception"));
        return mapper.entityToDTO(entity);
    }

    public void removeCpf(String cpf) {
        try {
            repository.deleteByCpf(cpf);
        } catch (EmptyResultDataAccessException e) {
            throw new GenericException(e.getMessage());
        }
    }

    public List<RestrictListDTO> findAllCpf() {
        List<RestrictList> list = repository.findAll();
        return mapper.entityListToDtoList(list);
    }
}
