package co.com.sofka.crud.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sofka.crud.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
    Optional<Categoria> findById(Long id);
}
