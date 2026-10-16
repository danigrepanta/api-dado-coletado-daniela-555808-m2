package com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.request;


import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.entity.TipoDado;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record DadoColetadoRequestDTO(

        @NotBlank(message = "O nome da sonda é obrigatório")
        @Size(min = 3, max = 100)
        String sondaNome,

        @NotBlank(message = "A agência espacial é obrigatória")
        @Size(min = 3, max = 100)
        String agenciaEspacial,

        @NotNull(message = "A data da coleta é obrigatória")
        @PastOrPresent(message = "A data não pode ser futura")
        LocalDate dataColeta,

        @NotNull(message = "O tipo do dado é obrigatório")
        TipoDado tipoDado,

        @NotNull(message = "O valor medido é obrigatório")
        BigDecimal valorMedido,

        @NotBlank(message = "A unidade de medida é obrigatória")
        @Size(min = 3, max = 100)
        String unidadeMedida

) {
}

