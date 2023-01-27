package dev.fujioka.java.avancado.web.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Curso {

    private int id;
    private String nome;
}
