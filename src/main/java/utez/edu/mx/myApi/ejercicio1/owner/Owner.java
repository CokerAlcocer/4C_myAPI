package utez.edu.mx.myApi.ejercicio1.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.myApi.ejercicio1.pet.Pet;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private Pet pet;

    public Owner() {
    }

    public Owner(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public Owner(long id, String fullName, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public Owner(String fullName, String phone, Pet pet) {
        this.fullName = fullName;
        this.phone = phone;
        this.pet = pet;
    }

    public Owner(long id, String fullName, String phone, Pet pet) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
