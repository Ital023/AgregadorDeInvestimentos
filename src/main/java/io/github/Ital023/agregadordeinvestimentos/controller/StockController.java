package io.github.Ital023.agregadordeinvestimentos.controller;

import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateStockDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.Stock;
import io.github.Ital023.agregadordeinvestimentos.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Void> createStock(@RequestBody CreateStockDTO createStockDTO){

        stockService.createStock(createStockDTO);
        return ResponseEntity.ok().build();
    }


}
