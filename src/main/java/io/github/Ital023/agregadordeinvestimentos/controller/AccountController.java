package io.github.Ital023.agregadordeinvestimentos.controller;


import io.github.Ital023.agregadordeinvestimentos.controller.dto.AccountStockResponseDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.AssociateAccountStockDTO;
import io.github.Ital023.agregadordeinvestimentos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStocks(@PathVariable("accountId") String accountId,
                                                @RequestBody AssociateAccountStockDTO dto){

        accountService.associateStock(accountId, dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDTO>> listAccountStocks(@PathVariable("accountId") String accountId){
        return ResponseEntity.ok(accountService.listStocks(accountId));
    }


}
