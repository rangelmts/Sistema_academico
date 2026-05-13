package com.sistema.academico.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusRegistro {
    ATIVO("A"),
    INATIVO("I");

    private final String codigo;
}
