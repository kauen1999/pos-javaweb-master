package dev.fujioka.java.avancado.web.dto;

import dev.fujioka.java.avancado.web.model.Professor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Builder
@Data
public class DisciplinaDTO {

    private String nome;

    private String categoria;

    private String cargaHoraria;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    private String status;

    private String observacos;
}
