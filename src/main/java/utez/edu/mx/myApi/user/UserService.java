package utez.edu.mx.myApi.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
        Map<String, Object> map = new HashMap<>();
        List<User> list = userRepository.findAll();

        if(list.size() != 0) {
            map.put("message", "Recursos obtenidos de manera exitosa");
        }
    }
}
