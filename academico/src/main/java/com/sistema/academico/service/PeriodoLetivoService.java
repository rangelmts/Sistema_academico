package com.sistema.academico.service;

import com.sistema.academico.model.PeriodoLetivo;
import com.sistema.academico.repository.PeriodoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeriodoLetivoService {

    @Autowired
    private PeriodoLetivoRepository periodoLetivoRepository;

    public List<PeriodoLetivo> listarTodos() {
        return periodoLetivoRepository.findAll();
    }
}