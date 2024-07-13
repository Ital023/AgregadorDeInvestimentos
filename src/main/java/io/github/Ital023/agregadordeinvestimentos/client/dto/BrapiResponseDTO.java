package io.github.Ital023.agregadordeinvestimentos.client.dto;

import java.util.List;

public record BrapiResponseDTO(List<StockDTO> results) {
}
