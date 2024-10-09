package utez.edu.mx.myApi.ejercicio1.pet;

import jakarta.persistence.*;
import utez.edu.mx.myApi.ejercicio1.building.Building;
import utez.edu.mx.myApi.ejercicio1.owner.Owner;
import utez.edu.mx.myApi.ejercicio1.type.Type;

import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private Type type;

    @OneToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id", unique = true, nullable = false)
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "pet_is_in_buildings",
            joinColumns = @JoinColumn(name = "id_pet"),
            inverseJoinColumns = @JoinColumn(name = "id_building")
    )
    private List<Building> buildings;

    public Pet() {
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Pet(String nickname, Type type, Owner owner, List<Building> buildings) {
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
        this.buildings = buildings;
    }

    public Pet(long id, String nickname, Type type, Owner owner, List<Building> buildings) {
        this.id = id;
        this.nickname = nickname;
        this.type = type;
        this.owner = owner;
        this.buildings = buildings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
