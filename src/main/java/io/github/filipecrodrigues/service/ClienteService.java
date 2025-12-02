package io.github.filipecrodrigues.service;


import io.github.filipecrodrigues.entity.Cliente;
import io.github.filipecrodrigues.repository.ClienteRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ClienteService {


    private final ClienteRepository repository;


    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }


    public List<Cliente> listarTodos() {
        return repository.findAll();
    }


    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }


    public Cliente atualizar(Long id, Cliente novoCliente) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(novoCliente.getNome());
        cliente.setEmail(novoCliente.getEmail());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setTelefone(novoCliente.getTelefone());
        return repository.save(cliente);
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }
}