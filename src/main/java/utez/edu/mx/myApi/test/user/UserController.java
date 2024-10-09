package utez.edu.mx.myApi.test.user;

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

    // http://ip:port/api/user - POST
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody User user) {
        return userService.save(user);
    }

    // http://ip:port/api/user - PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable long id) {
        return userService.update(user, id);
    }

    // http://ip:port/api/user - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
