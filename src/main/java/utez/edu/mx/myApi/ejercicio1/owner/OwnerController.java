package utez.edu.mx.myApi.ejercicio1.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin(origins = {"*"})
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ownerService.findAll();
    }
}
