package dev.fujioka.java.avancado.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfessorDTO {

    private String nome;
    private String cod;
}
