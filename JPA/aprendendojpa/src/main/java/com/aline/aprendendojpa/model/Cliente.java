package com.aline.aprendendojpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table (name="cliente")
@Entity
public class Cliente {

    public Cliente() { // JPA espera um construtor default sem parâmetros

    }

    public Cliente(long id, String nome) {

        this.nome = nome;
    }

    @Id // primary key
    @GeneratedValue // dizendo que esse valor será um valor gerado
    @Column(name="id")
    private long id;

    @Column(name="nome")
    private String nome;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
