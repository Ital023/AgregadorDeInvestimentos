package io.github.Ital023.agregadordeinvestimentos.service;

import io.github.Ital023.agregadordeinvestimentos.controller.dto.AccountStockResponseDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.AssociateAccountStockDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.AccountStock;
import io.github.Ital023.agregadordeinvestimentos.entities.AccountStockId;
import io.github.Ital023.agregadordeinvestimentos.repositories.AccountRepository;
import io.github.Ital023.agregadordeinvestimentos.repositories.AccountStockRepository;
import io.github.Ital023.agregadordeinvestimentos.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AccountStockRepository accountStockRepository;

    public void associateStock(String accountId, AssociateAccountStockDTO dto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var stock = stockRepository.findById(dto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var id = new AccountStockId(account.getAccountId(), stock.getStockId());

        var entity = AccountStock
                .builder()
                .id(id)
                .account(account)
                .stock(stock)
                .quantity(dto.quantity())
                .build();

        accountStockRepository.save(entity);

    }


    public List<AccountStockResponseDTO> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return account.getAccountStocks()
                .stream()
                .map(as -> new AccountStockResponseDTO(as.getStock().getStockId(), as.getQuantity(), 0.0))
                .toList();


    }

}
