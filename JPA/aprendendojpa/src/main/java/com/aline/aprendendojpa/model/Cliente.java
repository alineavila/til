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

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;




}
