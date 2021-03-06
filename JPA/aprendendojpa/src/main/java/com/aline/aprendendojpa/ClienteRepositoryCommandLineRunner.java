package com.aline.aprendendojpa;

import ch.qos.logback.core.net.server.Client;
import com.aline.aprendendojpa.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component // dizenmos que será gerenciado pelo spring ou seja, componente do spring
    public class ClienteRepositoryCommandLineRunner implements CommandLineRunner {

        private static final Logger log = // método para pegar o log dessa classe
                LoggerFactory.getLogger(com.aline.aprendendojpa.ClienteRepository.class); // pegando o log da classe

        @Autowired // diz para o spring  que ele pode gerenciar esse serviço injetar outros serviços de suporte
                ClienteRepository clienteRepository;


        @Override
        public void run(String... args) throws Exception { // metodo obrigatorio para o CommandLineRunner
            Cliente cliente = new Cliente ("testando repository"); // para salvar esse cliente precisamos do serviço que se conecta com o bd
            clienteRepository.save(cliente);

            Optional<Cliente> clienteComID2 =  clienteRepository.findById(2L);
            log.info("Cliente encontrado: " + clienteComID2); // log da classe

            List<Cliente> clientes = clienteRepository.findAll();
            log.info("Todos os clientes: " + clientes);


        }
    }


