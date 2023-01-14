package dev.fujioka.java.avancado.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String duracao;

}
