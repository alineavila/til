package br.com.alura.forum.controller.dto;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Topico;

public class TopicoDto {
    // sem classes de dominio
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    
    
    
    public TopicoDto(Topico topico) {
    	this.id = topico.getId();
    	this.titulo = topico.getTitulo();
    	this.mensagem = topico.getMensagem();
    	this.dataCriacao = topico.getDataCriacao();
    	
    }
    
    
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public static List<TopicoDto> converter(List<Topico> topicos) {
		// TODO Auto-generated method stub
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}
    
    
}

