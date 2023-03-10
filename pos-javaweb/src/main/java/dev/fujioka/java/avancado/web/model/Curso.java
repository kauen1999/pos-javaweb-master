package dev.fujioka.java.avancado.web.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter

public class Curso implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String codigo;
    private String nome;
}
