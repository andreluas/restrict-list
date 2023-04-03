package br.com.andreluas.restrictlist.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.andreluas.restrictlist.dtos.RestrictListDTO;
import br.com.andreluas.restrictlist.dtos.RestrictListInsertDTO;
import br.com.andreluas.restrictlist.services.RestrictListService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/api/v1")
public class RestrictListController {

    @Autowired
    private RestrictListService service;

    @GetMapping(value = "/cpf")
    public ResponseEntity<List<RestrictListDTO>> findAllCpf() {
        List<RestrictListDTO> list = service.findAllCpf();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<RestrictListDTO> checkCpf(@PathVariable String cpf) {
        RestrictListDTO dto = service.checkCpf(cpf);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/cpf")
    public ResponseEntity<RestrictListInsertDTO> addCpf(@RequestBody @Valid RestrictListInsertDTO dto) {
        RestrictListInsertDTO restrictListDTO = service.addCpf(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
                .buildAndExpand(restrictListDTO.getCpf())
                .toUri();
        return ResponseEntity.created(uri).body(restrictListDTO);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Void> removeCpf(@PathVariable String cpf) {
        service.removeCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
