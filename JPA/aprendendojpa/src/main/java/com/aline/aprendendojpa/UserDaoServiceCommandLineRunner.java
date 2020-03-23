package com.aline.aprendendojpa;

 /*
    Toda vez que uma aplicação spring roda ela está também rodando algo chamado
    spring context. Podemos fazer que ao rodar o spring context nos queremos inserir um cliente.
    Como faremos isso? Existe um conceito chamado command line runner, esse comando é executado
    quando o contexto spring é iniciado.
 */

import com.aline.aprendendojpa.model.Cliente;
import com.aline.aprendendojpa.service.ClienteDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // dizenmos que será gerenciado pelo spring ou seja, componente do spring
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log = // método para pegar o log dessa classe
            LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class); // pegando o log da classe

    @Autowired // diz para o spring  que ele pode gerenciar esse serviço injetar outros serviços de suporte
    ClienteDAOService clienteDAOService;


    @Override
    public void run(String... args) throws Exception { // metodo obrigatorio para o CommandLineRunner
        Cliente cliente = new Cliente ("teste vendo sql"); // para salvar esse cliente precisamos do serviço que se conecta com o bd
        long insert = clienteDAOService.insert(cliente); // pq retorna um id long
        log.info("Novo Cliente foi criado: " + cliente); // log da classe

    }
}
