package com.aline.aprendendojpa.service;

import com.aline.aprendendojpa.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

// em Spring precisamos dizer que esse objeto irá se comunicar com o banco de dados dizemos com a anotação @Repository
@Repository // significa que é algo que interage com o banco de dados
@Transactional // diz que esse método é uma transação
public class ClienteDAOService { // sigla para data access

    // nessa classe devemos ser capazes de manipular o banco de dados
    // para isso a primeira coisa que faremos é criar uma instância do Entity Manager

    @PersistenceContext // para que o a instancia do bd criada seja mapeada pelo contexto de persistência
    private EntityManager entityManager;

    public long insert(Cliente cliente){
        // Toda alteração no banco é uma transação

        // abre a transção e faz a modificação/ação
//        entityManager.persist(cliente); // metodo usado para criar uma instancia e persisti-la
        // fecha a transação
        // para isso precisamos dizer para o Spring que é uma transação passando a anotação @Transactional
        return cliente.getId();
    }

}
