package io.github.Ital023.agregadordeinvestimentos.service;

import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateAccountDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.UpdateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.Account;
import io.github.Ital023.agregadordeinvestimentos.entities.BillingAddress;
import io.github.Ital023.agregadordeinvestimentos.entities.User;
import io.github.Ital023.agregadordeinvestimentos.repositories.AccountRepository;
import io.github.Ital023.agregadordeinvestimentos.repositories.BillingAddressRepository;
import io.github.Ital023.agregadordeinvestimentos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @Autowired
    private AccountRepository accountRepository;


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


    public void createAccount(String userId, CreateAccountDTO createAccountDTO) {

        var user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Account account = Account
                .builder()
                .user(user)
                .billingAddress(null)
                .description(createAccountDTO.description())
                .accountStocks(new ArrayList<>())
                .build();

        Account accountCreated = accountRepository.save(account);

        BillingAddress billingAddress = BillingAddress
                .builder()
                .id(accountCreated.getAccountId())
                .account(accountCreated)
                .street(createAccountDTO.street())
                .number(createAccountDTO.number())
                .build();

        billingAddressRepository.save(billingAddress);

    }
}
