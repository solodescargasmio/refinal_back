package co.com.sofka.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String name;
    
    private boolean isCompleted;

    @ManyToOne()
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Todo(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
    public Todo() {
    }

    public Long getCategoria() {
        return categoria.getId();
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    

    public Todo(String name, boolean isCompleted, Categoria categoria) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.categoria = categoria;
    }



    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Todo [categoria=" + categoria + ", id=" + id + ", isCompleted=" + isCompleted + ", name=" + name + "]";
    }
}
