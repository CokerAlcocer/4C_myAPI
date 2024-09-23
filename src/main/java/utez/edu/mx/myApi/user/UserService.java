package utez.edu.mx.myApi.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> findAll() {
        Map<String, Object> body = new HashMap<>();
        List<User> list = userRepository.findAll();

        body.put("message", list.isEmpty() ? "Aún no hay registros" : "Operación exitosa");
        body.put("status", 200);
        body.put("data", list);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(long id) {
        Map<String, Object> body = new HashMap<>();
        User found = userRepository.findById(id);

        body.put("message", found == null ? "Registro no encontrado" : "Operación exitosa");
        body.put("status", found == null ? 404 : 200);
        body.put("data", found);

        return new ResponseEntity<>(body, found == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
    }
}
