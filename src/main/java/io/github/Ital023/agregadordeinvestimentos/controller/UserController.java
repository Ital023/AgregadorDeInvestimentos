package io.github.Ital023.agregadordeinvestimentos.controller;


import io.github.Ital023.agregadordeinvestimentos.controller.dto.AccountResponseDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateAccountDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.UpdateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.User;
import io.github.Ital023.agregadordeinvestimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO userDTO){
        UUID id = userService.createUser(userDTO);
        return ResponseEntity.created(URI.create("/v1/users/" + id.toString())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
         Optional<User> user = userService.getUserById(userId);

         if(user.isPresent()) return ResponseEntity.ok(user.get());

         return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        return ResponseEntity.ok(userService.listUsers());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId
            , @RequestBody UpdateUserDTO updateUserDTO) {

        userService.updateUserById(userId,updateUserDTO);

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
        userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Void> createAccount(@PathVariable("userId") String userId,
                                              @RequestBody CreateAccountDTO createAccountDTO){

        userService.createAccount(userId,createAccountDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/accounts")
    public ResponseEntity<List<AccountResponseDTO>> listAccounts(@PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.listAccounts(userId));
    }

}
