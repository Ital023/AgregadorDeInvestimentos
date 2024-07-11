package io.github.Ital023.agregadordeinvestimentos.repositories;

import io.github.Ital023.agregadordeinvestimentos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
