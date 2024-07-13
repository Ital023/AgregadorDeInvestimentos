package io.github.Ital023.agregadordeinvestimentos.service;

import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateStockDTO;
import io.github.Ital023.agregadordeinvestimentos.controller.dto.CreateUserDTO;
import io.github.Ital023.agregadordeinvestimentos.entities.Stock;
import io.github.Ital023.agregadordeinvestimentos.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void createStock(CreateStockDTO createStockDTO){

        Stock stock = Stock
                .builder()
                .stockId(createStockDTO.stockId())
                .description(createStockDTO.description())
                .build();

        stockRepository.save(stock);
    }

}
