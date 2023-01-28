package dev.fujioka.java.avancado.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CursoDTO {

    private String codigo;
    private String nome;
}
