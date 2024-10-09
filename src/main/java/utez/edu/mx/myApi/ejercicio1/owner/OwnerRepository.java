package utez.edu.mx.myApi.ejercicio1.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query(value = "SELECT * FROM owner WHERE id not in (SELECT id_owner FROM pet);", nativeQuery = true)
    List<Owner> findAll();
}
