package utez.edu.mx.myApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // http://ip:port/api/user - GET
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return userService.findAll();
    }
    // http://ip:port/api/user/{id} - GET
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return userService.findById(id);
    }
}
