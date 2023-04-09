package com.contratosc.crud.view.controller;

//#region imports
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.contratosc.crud.model.Cliente;
import com.contratosc.crud.services.ClienteService;
//#endregion

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;
    
    /**
     * Método para pesquisar todos os Clientes via requisição GET
     * @return lista de clientes
     */
    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    /**
     * Método para buscar Cliente por Id via requisição GET
     * @return cliente cadastrado pelo id
     */
    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable Integer id){
        return clienteService.findById(id);
    }

    /**
     * Método para adicionar Cliente via requisição POST
     * @return cliente adicionado
     */
    @PostMapping
    public Cliente addProduct(@RequestBody Cliente cliente){
        return clienteService.addCliente(cliente);
    }

    /**
     * Método para deletar Cliente via requisição DELETE
     * @return void
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        clienteService.deleteById(id);
    }

    /**
     * Método para atualizar Cliente via requisição PUT
     * @return cliente  com dados atualizados
     */
    @PutMapping("/{id}")
    public Cliente updateProduct(@PathVariable Integer id, @RequestBody Cliente cliente){
        cliente.setId(id);
        return clienteService.updateProduct(id, cliente);
    }

}
