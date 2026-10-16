package com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.service;

import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.request.DadoColetadoRequestDTO;
import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.dto.response.DadoColetadoResponseDTO;
import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.entity.DadoColetado;
import com.github.danigrepanta.api_dado_coletado_daniela_555808_m2.repository.DadoColetadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DadoColetadoService {

    private final DadoColetadoRepository repository;

    public DadoColetadoService(DadoColetadoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public DadoColetadoResponseDTO cadastrar(
            DadoColetadoRequestDTO dto) {

        DadoColetado entidade = new DadoColetado();
        copiarDados(dto, entidade);

        return converter(repository.save(entidade));
    }

    @Transactional(readOnly = true)
    public List<DadoColetadoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    @Transactional(readOnly = true)
    public DadoColetadoResponseDTO buscarPorId(Long id) {
        return converter(buscarEntidade(id));
    }

    @Transactional
    public DadoColetadoResponseDTO atualizar(
            Long id, DadoColetadoRequestDTO dto) {

        DadoColetado entidade = buscarEntidade(id);
        copiarDados(dto, entidade);

        return converter(repository.save(entidade));
    }

    @Transactional
    public void excluir(Long id) {
        DadoColetado entidade = buscarEntidade(id);
        repository.delete(entidade);
    }

    private DadoColetado buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Dado coletado não encontrado: " + id
                ));
    }

    private void copiarDados(
            DadoColetadoRequestDTO dto,
            DadoColetado entidade) {

        entidade.setSondaNome(dto.sondaNome());
        entidade.setAgenciaEspacial(dto.agenciaEspacial());
        entidade.setDataColeta(dto.dataColeta());
        entidade.setTipoDado(dto.tipoDado());
        entidade.setValorMedido(dto.valorMedido());
        entidade.setUnidadeMedida(dto.unidadeMedida());
    }

    private DadoColetadoResponseDTO converter(
            DadoColetado entidade) {

        return new DadoColetadoResponseDTO(
                entidade.getDadoId(),
                entidade.getSondaNome(),
                entidade.getAgenciaEspacial(),
                entidade.getDataColeta(),
                entidade.getTipoDado(),
                entidade.getValorMedido(),
                entidade.getUnidadeMedida()
        );
    }
}

