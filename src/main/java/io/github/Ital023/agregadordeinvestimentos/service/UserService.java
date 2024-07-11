package io.github.Ital023.agregadordeinvestimentos.service;

import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.UpdateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.User;
import io.github.Ital023.agregadordeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UUID createUser(CreateUserDTO createUserDTO){
        User user = User
                .builder()
                .username(createUserDTO.username())
                .email(createUserDTO.email())
                .password(createUserDTO.password())
                .build();

        User userSaved = userRepository.save(user);

        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void deleteById(String userId){

        UUID id = UUID.fromString(userId);

        boolean userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }

    }

    public void updateUserById(String userId, UpdateUserDTO updateUserDTO) {

        UUID id = UUID.fromString(userId);

        Optional<User> userEntity = userRepository.findById(id);

        if (userEntity.isPresent()) {
            User user = userEntity.get();

            if(updateUserDTO.username() != null) {
                user.setUsername(updateUserDTO.username());
            }

            if(updateUserDTO.password() != null) {
                user.setPassword(updateUserDTO.password());
            }

            userRepository.save(user);

        }

    }



}
