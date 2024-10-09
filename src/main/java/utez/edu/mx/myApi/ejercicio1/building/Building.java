package utez.edu.mx.myApi.ejercicio1.building;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.myApi.ejercicio1.pet.Pet;

import java.util.List;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "buildings")
    @JsonIgnore
    private List<Pet> pets;

    public Building() {
    }

    public Building(String name) {
        this.name = name;
    }

    public Building(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Building(String name, List<Pet> pets) {
        this.name = name;
        this.pets = pets;
    }

    public Building(long id, String name, List<Pet> pets) {
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
