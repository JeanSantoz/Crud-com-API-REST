package com.contratosc.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratosc.crud.model.Cliente;
import com.contratosc.crud.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientRepository;

    
    /**
     * Método para buscar todos os Clientes via requisição GET
     * @return  lista de clientes
     */
    public List<Cliente> findAll(){
        return clientRepository.findAll();
    }

    /**
     * Método para buscar Cliente por Id via requisição GET
     * @return cliente  de id correspondente
     */
    public Optional<Cliente> findById(Integer id){
        return clientRepository.findById(id);
    }

    /**
     * Método para adicionar Cliente via requisição POST
     * @return cliente  adcionado
     */
    public Cliente addCliente(Cliente cliente){
        return clientRepository.save(cliente);
    }

    /**
     * Método para deletar Cliente via requisição DELETE
     * @return void
     */
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    /**
     * Método para atualizar Cliente via requisição PUT
     * @return cliente  com dados atualizados
     */
    public Cliente updateProduct(Integer id, Cliente cliente){
        cliente.setId(id);
        return clientRepository.save(cliente);
    }

}