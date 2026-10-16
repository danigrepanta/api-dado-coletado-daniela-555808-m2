package com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.response;


import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.entity.TipoDado;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoColetadoResponseDTO(
        Long dadoId,
        String sondaNome,
        String agenciaEspacial,
        LocalDate dataColeta,
        TipoDado tipoDado,
        BigDecimal valorMedido,
        String unidadeMedida
) {
}
