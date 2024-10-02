package utez.edu.mx.myApi.ejercicio1.pet;

import jakarta.persistence.*;
import utez.edu.mx.myApi.ejercicio1.Building;
import utez.edu.mx.myApi.ejercicio1.Owner;
import utez.edu.mx.myApi.ejercicio1.Type;

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
}
