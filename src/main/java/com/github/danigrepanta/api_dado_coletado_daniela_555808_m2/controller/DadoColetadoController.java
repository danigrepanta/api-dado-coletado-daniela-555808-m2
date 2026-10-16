package com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.controller;


import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.request.DadoColetadoRequestDTO;
import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.response.DadoColetadoResponseDTO;
import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.service.DadoColetadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dados-coletados")
public class DadoColetadoController {

    private final DadoColetadoService service;

    public DadoColetadoController(DadoColetadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DadoColetadoResponseDTO> cadastrar(
            @Valid @RequestBody DadoColetadoRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<DadoColetadoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadoColetadoResponseDTO> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadoColetadoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody DadoColetadoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

