package co.com.sofka.crud.service;

import java.util.Optional;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Todo get(Long id){
        Optional<Todo> todos= this.repository.findById(id);
        Todo todo=todos.get();
        return todo;
    }


}
