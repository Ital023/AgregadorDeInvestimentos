package io.github.Ital023.agregadordeinvestimentos.repositories;

import io.github.Ital023.agregadordeinvestimentos.entities.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {
}
