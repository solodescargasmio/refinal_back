package co.com.sofka.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.crud.model.Categoria;
import co.com.sofka.crud.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository catRepo;

    
    public Iterable<Categoria> list(){
        return catRepo.findAll();
    }

    public Categoria save(Categoria categoria){
        return catRepo.save(categoria);
    }

    public void delete(Long id){
        catRepo.delete(get(id));
    }

    public void deleteCategoria(Categoria categoria)
    {
        catRepo.delete(categoria);
    }
/*
    public Optional<Categoria> findByName(String nombre){
        Optional<Categoria> cat = catRepo.findByName(nombre);
    return cat;
        }
*/
    public Categoria get(Long id){
        Optional<Categoria> categorias= this.catRepo.findById(id);
        Categoria categoria=categorias.get();
        return categoria;
    }

}
