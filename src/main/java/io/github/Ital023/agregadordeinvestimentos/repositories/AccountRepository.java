package io.github.Ital023.agregadordeinvestimentos.repositories;

import io.github.Ital023.agregadordeinvestimentos.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
