package com.example.migracao.migracao;

import java.net.URI;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) throws SQLException {
        UserData user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Long> postUser(@RequestBody UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder){
        UserData save = userService.registerUser(userDTO);
        URI uri = uriComponentsBuilder.path("user/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save.getId());
    }

}
