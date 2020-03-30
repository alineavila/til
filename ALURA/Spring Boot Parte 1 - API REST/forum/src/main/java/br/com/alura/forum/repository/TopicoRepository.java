package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topico;

//como é interface e não classe, não precisa colocar nenhuma anotação
// vamos herdar de alguma interface do jpa
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso); // curso é a entidade de relacionamento, nome é o atributo que eu quero achar dessa entidade
	// o SpringData já sabe que é pra fazer os joins  
}
