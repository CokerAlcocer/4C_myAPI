package utez.edu.mx.myApi.ejercicio1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
@CrossOrigin(origins = {"*"})
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return petService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Pet pet) {
        return petService.update(id, pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return petService.deleteById(id);
    }
}
