package com.sistema.academico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseDTO<T> {
    private boolean sucesso;
    private T dados;
    private String mensagem;

    public static <T> ApiResponseDTO<T> success(T dados) {
        return ApiResponseDTO.<T>builder()
                .sucesso(true)
                .dados(dados)
                .build();
    }

    public static <T> ApiResponseDTO<T> error(String mensagem) {
        return ApiResponseDTO.<T>builder()
                .sucesso(false)
                .mensagem(mensagem)
                .build();
    }
}
