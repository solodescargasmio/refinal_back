package co.com.sofka.crud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.service.TodoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria/todo")
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping()
    public Iterable<Todo> list(){
        return service.list();
    }

    @PostMapping()
    public String save(@RequestBody Todo todo){
        return "DENTRO POST  ";//service.save(todo);
    }

    @PostMapping("/")
    public Todo saveTodo(@RequestBody Todo todo){

           return service.save(todo);
         
    }

    @PutMapping()
    public Todo update(@RequestBody Todo todo){
        if(todo.getId()!=null){
            return service.save(todo);
        }else throw new RuntimeException("No existe el id para actualizar");
        
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }  
}
