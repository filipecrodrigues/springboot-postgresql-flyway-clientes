package io.github.filipecrodrigues.controller;



import io.github.filipecrodrigues.entity.Cliente;
import io.github.filipecrodrigues.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService service;


    public ClienteController(ClienteService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody Cliente cliente) {
        cliente.setId(null); //para forçar o insert
        return service.salvar(cliente);
    }

    @PostMapping("/lote")
    public List<Cliente> criarEmLote(@RequestBody List<Cliente> clientes){
        return service.salvarVarios(clientes);
    }


    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}