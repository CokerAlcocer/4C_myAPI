package utez.edu.mx.myApi.ejercicio1.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAll();
    Pet findById(long id);
    Pet save(Pet p);//guardar y actualizar
    @Modifying
    @Query(value = "DELETE FROM pet WHERE id = :id;", nativeQuery = true)
    void deleteById(@Param("id") long id);
}
