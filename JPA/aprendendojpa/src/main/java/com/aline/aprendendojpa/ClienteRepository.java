package com.aline.aprendendojpa;

import com.aline.aprendendojpa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

 /*
    Vamos dizer que queremos criar outra classe que mapeasse, por exemplo outra tabela no nosso bd
    teríamos que fazer tudo novamente aoenas mudando o nome das classes. No caso de apenas salvar
    esse é o método que se repetiria:
       @PersistenceContext
    private EntityManager entityManage{
    public long insert(Cliente cliente){
        entityManager.persist(cliente);
        return cliente.getId();
    }
    Para cada ação do CRUD um método parecido a esse deveria ser repetido.
    Para essa questão o JPA tem uma solução mais amigável e menos repetitiva que é a criação de Repository com
    métodos padrão (apenas a interface do método) e o JPA cuidaria de implementar aquele método, seja para save
    create, update, delete
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> { // entidade que queremos manipular

}
