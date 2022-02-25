package co.com.sofka.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.crud.model.Categoria;
import co.com.sofka.crud.service.CategoriaService;

@RestController
@CrossOrigin(origins ="http://localhost:8080")

@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService icategoria;
    @GetMapping()
    public Iterable<Categoria> getTodasCategorias(){
        return icategoria.list();
    }
   @PostMapping()
    public Categoria guardarCategoriaString(@RequestParam String nombre){
        Categoria categoria=new Categoria();
        categoria.setNombre(nombre);
        return this.icategoria.save(categoria);
    }
    @PostMapping("/")
    public Categoria guardarRole(@RequestBody Categoria categoria){
        return this.icategoria.save(categoria);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        try {
            this.icategoria.delete(id);
            return "EMPLOYEE DELETE!!!!";
        } catch (Exception e) {
            return "ERROR DELETE "+e.getMessage();
        }
        
    }

    @DeleteMapping("/")
    public String deleteEmployee(@RequestParam Categoria categoria){
        try {
            this.icategoria.deleteCategoria(categoria);
            return "EMPLOYEE DELETE!!!!";
        } catch (Exception e) {
            return "ERROR DELETE "+e.getMessage();
        }
    }
}