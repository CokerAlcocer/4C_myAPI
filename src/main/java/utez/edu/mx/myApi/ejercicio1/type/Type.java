package utez.edu.mx.myApi.ejercicio1.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.myApi.ejercicio1.pet.Pet;

import java.util.List;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private List<Pet> pets;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type(String name, List<Pet> pets) {
        this.name = name;
        this.pets = pets;
    }

    public Type(long id, String name, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
