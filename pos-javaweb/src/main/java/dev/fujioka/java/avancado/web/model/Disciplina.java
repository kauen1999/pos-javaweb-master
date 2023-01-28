package dev.fujioka.java.avancado.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String categoria;

    private String cargaHoraria;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    private String status;

    private String observacos;

}