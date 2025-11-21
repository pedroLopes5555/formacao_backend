package com.formacao.demo_formacao_backend.Controllers;

import com.formacao.demo_formacao_backend.Entities.UserDTO;
import com.formacao.demo_formacao_backend.Services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing User entities.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {


    private final IUserService userService;

    /**
     * Constructor injection of the UserService.
     *
     * @param userService Service for user operations
     */
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     *
     * @param name Name of the user to create
     * @return ResponseEntity with the created User and HTTP status
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String password) {
        var createdUser = userService.createUser(name, age, password);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @RequestParam String name,
                                        @RequestParam int age,
                                        @RequestParam String password)
    {

        var user = userService.updateUser(id, name, age, password);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }



    /**
     * Get a user by ID.
     *
     * @param id User ID
     * @return ResponseEntity with the User if found, or 404 if not
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    /**
     * Get all users with a given name.
     *
     * @param name Name to search for
     * @return List of users with the specified name
     */
    @GetMapping("/by-name")
    public ResponseEntity<?> getAllByName(@RequestParam String name) {
        var users = userService.getAllByName(name);
        return ResponseEntity.ok(users);
    }
}
