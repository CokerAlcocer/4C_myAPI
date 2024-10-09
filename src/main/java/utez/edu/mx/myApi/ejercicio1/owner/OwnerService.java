package utez.edu.mx.myApi.ejercicio1.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<?> findAll() {
        Map<String, Object> body = new HashMap<>();
        List<Owner> list = ownerRepository.findAll();

        body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación exitosa");
        body.put("code", 200);
        body.put("status", "OK");
        body.put("data", list);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
