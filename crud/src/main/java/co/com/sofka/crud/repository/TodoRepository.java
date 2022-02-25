package co.com.sofka.crud.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sofka.crud.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
    Optional<Todo> findById(Long id);
}
