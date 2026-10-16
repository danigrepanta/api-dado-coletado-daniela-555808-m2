package com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

    @Entity
    @Table(name = "dados_coletados")
    public class DadoColetado {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long dadoId;

        @Column(nullable = false, length = 100)
        private String sondaNome;

        @Column(nullable = false, length = 100)
        private String agenciaEspacial;

        @Column(nullable = false)
        private LocalDate dataColeta;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 30)
        private TipoDado tipoDado;

        @Column(nullable = false, precision = 15, scale = 4)
        private BigDecimal valorMedido;

        @Column(nullable = false, length = 100)
        private String unidadeMedida;

        public DadoColetado() {
        }

        public Long getDadoId() {
            return dadoId;
        }

        public void setDadoId(Long dadoId) {
            this.dadoId = dadoId;
        }

        public String getSondaNome() {
            return sondaNome;
        }

        public void setSondaNome(String sondaNome) {
            this.sondaNome = sondaNome;
        }

        public String getAgenciaEspacial() {
            return agenciaEspacial;
        }

        public void setAgenciaEspacial(String agenciaEspacial) {
            this.agenciaEspacial = agenciaEspacial;
        }

        public LocalDate getDataColeta() {
            return dataColeta;
        }

        public void setDataColeta(LocalDate dataColeta) {
            this.dataColeta = dataColeta;
        }

        public TipoDado getTipoDado() {
            return tipoDado;
        }

        public void setTipoDado(TipoDado tipoDado) {
            this.tipoDado = tipoDado;
        }

        public BigDecimal getValorMedido() {
            return valorMedido;
        }

        public void setValorMedido(BigDecimal valorMedido) {
            this.valorMedido = valorMedido;
        }

        public String getUnidadeMedida() {
            return unidadeMedida;
        }

        public void setUnidadeMedida(String unidadeMedida) {
            this.unidadeMedida = unidadeMedida;
        }
    }


