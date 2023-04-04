package br.com.andreluas.restrictlist.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.andreluas.restrictlist.factory.Factory;
import br.com.andreluas.restrictlist.models.RestrictList;
import br.com.andreluas.restrictlist.services.exceptions.NotFoundCpfException;

@DataJpaTest
public class RestrictListRepositoryTests {

    @Autowired
    private RestrictListRepository repository;

    private String existingCpf;
    private String nonExistingCpf;
    private Integer countTotalCpf;

    @BeforeEach
    void setUp() throws Exception {
        existingCpf = "21198683015";
        nonExistingCpf = "81198683018";
        countTotalCpf = 3;
    }

    @Test
    public void findByCpfShouldReturnNonEmptyOptionalWhenCpfExists() {
        Optional<RestrictList> result = repository.findByCpf(existingCpf);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void findByCpfShouldReturnEmptyOptionalWhenCpfDoesNotExist() {
        Optional<RestrictList> result = repository.findByCpf(nonExistingCpf);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
        RestrictList entity = Factory.create();
        entity.setId(null);
        repository.save(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertEquals(countTotalCpf + 1, 4);
    }

    @Test
    public void deleteShouldDeleteObjectWhenCpfExists() {
        Optional<RestrictList> op = repository.findByCpf(existingCpf);
        RestrictList entity = op.get();
        repository.deleteById(entity.getId());
        Optional<RestrictList> verify = repository.findByCpf(existingCpf);
        Assertions.assertFalse(verify.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultNotFoundCpfExceptionWhenCpfDoesNotExist() {
        Assertions.assertThrows(NotFoundCpfException.class, () -> {
            Optional<RestrictList> op = repository.findByCpf(nonExistingCpf);
            RestrictList entity = op.orElseThrow(() -> new NotFoundCpfException("CPF not found."));
            repository.deleteById(entity.getId());
        });
    }
}
