package com.aline.aprendendojpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table (name="cliente")
public class Cliente {

    public Cliente() { // JPA espera um construtor default sem parâmetros

    }

    public Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Id
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
