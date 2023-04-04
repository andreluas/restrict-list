package br.com.andreluas.restrictlist.factory;

import java.time.Instant;
import java.util.UUID;

import br.com.andreluas.restrictlist.dtos.RestrictListTestDTO;
import br.com.andreluas.restrictlist.models.RestrictList;

public class Factory {

    public static RestrictList create() {
        Instant instant = Instant.now();
        UUID uuid = UUID.randomUUID();
        RestrictList entity = new RestrictList(uuid, "21641744022", instant);
        return entity;
    }

    public static RestrictListTestDTO createDTO() {
        RestrictList entity = create();
        return new RestrictListTestDTO(entity.getCpf(), entity.getCreatedAt());
    }
}
