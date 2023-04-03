package br.com.andreluas.restrictlist.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.andreluas.restrictlist.dtos.RestrictListDTO;
import br.com.andreluas.restrictlist.dtos.RestrictListInsertDTO;
import br.com.andreluas.restrictlist.models.RestrictList;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface RestrictListMapper {

    RestrictList dtoToEntity(RestrictListInsertDTO restrictListDTO);

    RestrictListDTO entityToDTO(RestrictList restrictList);

    RestrictListInsertDTO entityToInsertDTO(RestrictList restrictList);

    List<RestrictListDTO> entityListToDtoList(List<RestrictList> list);
}
