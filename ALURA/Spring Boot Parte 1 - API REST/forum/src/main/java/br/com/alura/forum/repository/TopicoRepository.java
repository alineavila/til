package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topico;

//como é interface e não classe, não precisa colocar nenhuma anotação
// vamos herdar de alguma interface do jpa
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
