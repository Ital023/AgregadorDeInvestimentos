package io.github.Ital023.agregadordeinvestimentos.repositories;

import io.github.Ital023.agregadordeinvestimentos.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
