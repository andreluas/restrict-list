package br.com.andreluas.restrictlist.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andreluas.restrictlist.models.RestrictList;

@Repository
public interface RestrictListRepository extends JpaRepository<RestrictList, UUID> {

    Optional<RestrictList> findByCpf(String cpf);
}
