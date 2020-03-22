package com.algaworks.sistemausuarios;

import com.algaworks.sistemausuarios.dto.UsuarioDTO;
import com.algaworks.sistemausuarios.model.Dominio;
import com.algaworks.sistemausuarios.model.Usuario;

import javax.persistence.*;
import java.util.List;

public class ConsultasComJPQL {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Usuarios-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        primeirasConsultas(entityManager);
//        escolhendoORetorno(entityManager);
//        fazendoProjecoes(entityManager);
        passandoParametros(entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void passandoParametros(EntityManager entityManager) {
        String jpql = "select u from Usuario u where u.id = :idUsuario"; // dizendo que a consulta espera um parâmetro
        TypedQuery<Usuario> typedQuery = entityManager.
                createQuery(jpql, Usuario.class).
                setParameter("idUsuario", 1); // passando o parâmetro pra consulta
        Usuario usuario = typedQuery.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());


        String jpqlLog = "select u from Usuario u where u.login = :loginUsuario";
        TypedQuery<Usuario> typedQueryLog = entityManager.
                createQuery(jpqlLog, Usuario.class).
                setParameter("loginUsuario", "ria"); // primeiro parametro: nome do parametro, segundo parametro o valor de fato
        Usuario usuarioLog = typedQueryLog.getSingleResult();
        System.out.println(usuarioLog.getId() + ", " + usuarioLog.getNome());
    }

    public static void fazendoProjecoes(EntityManager entityManager) {
        String jpqlArr = "select id, login, nome from Usuario";
        TypedQuery<Object[]> typedQueryArr = entityManager.createQuery(jpqlArr, Object[].class);
        List<Object[]> listaArr = typedQueryArr.getResultList();
        listaArr.forEach(arr -> System.out.println(String.format("%s, %s, %s", arr)));


        String jpqlDto = "select new com.algaworks.sistemausuarios.dto.UsuarioDTO(id, login, nome)" + // no select
                // precisa passar o caminho completo com o pacote e o nome da classe, entre parêntese
                // é como se fosse um construtor
                "from Usuario"; // Enviar retorno da consulta para um DTO
        TypedQuery<UsuarioDTO> typedQueryDto = entityManager.createQuery(jpqlDto, UsuarioDTO.class);
        List<UsuarioDTO> listaDto = typedQueryDto.getResultList(); // uma lista do DTO
        listaDto.forEach(u -> System.out.println("DTO: " + u.getId() + ", " + u.getNome()));
    }

    public static void escolhendoORetorno(EntityManager entityManager) {
        String jpql = "select u.dominio from Usuario u where u.id = 1";
        TypedQuery<Dominio> typedQuery = entityManager.createQuery(jpql, Dominio.class);
        Dominio dominio = typedQuery.getSingleResult();
        System.out.println(dominio.getId() + ", " + dominio.getNome());

        String jpqlNom = "select u.nome from Usuario u";
        TypedQuery<String> typedQueryNom = entityManager.createQuery(jpqlNom, String.class);
        List<String> listaNom = typedQueryNom.getResultList();
        listaNom.forEach(nome -> System.out.println(nome));
    }

    public static void primeirasConsultas(EntityManager entityManager) { // instância do entitymanager
        String jpql = "select u from Usuario u"; // selecionar registro do usuário da entidade usuario
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class); // query tipada
                                                                   // primeiro parametro: a consulta, segundo parametro o que retorna
        List<Usuario> lista = typedQuery.getResultList(); // Lista de usuario pegando o resultado do typedQuery
        lista.forEach(u -> System.out.println(u.getId() + ", " + u.getNome())); //get são os gets e setters
        // retorna queries de todas as classes que a classe usuario depende, para que isso não aconteça é preciso usar o join fetch

        String jpqlSing = "select u from Usuario u where u.id = 1";
        TypedQuery<Usuario> typedQuerySing = entityManager.createQuery(jpqlSing, Usuario.class);
        Usuario usuario = typedQuerySing.getSingleResult();
        System.out.println(usuario.getId() + ", " + usuario.getNome());

        String jpqlCast = "select u from Usuario u where u.id = 1";
        Query query = entityManager.createQuery(jpqlCast); // query não tipada
        Usuario usuario2 = (Usuario) query.getSingleResult(); // tem que fazer um cast por isso o (Usuario)
        System.out.println(usuario2.getId() + ", " + usuario2.getNome());
    }
}
