package io.github.Ital023.agregadordeinvestimentos.repositories;

import io.github.Ital023.agregadordeinvestimentos.entities.AccountStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountStockRepository extends JpaRepository<AccountStock, UUID> {
}
