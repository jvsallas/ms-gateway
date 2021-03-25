package br.com.mercadosallas.feign.client;

import br.com.mercadosallas.dto.ClienteAtualizacaoForm;
import br.com.mercadosallas.dto.ClienteDto;
import br.com.mercadosallas.gateway.clientes.dto.ClienteForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "modulo-clientes", url = "http://localhost:8080/clientes")
public interface ClienteClient {

    @PostMapping
    ResponseEntity<ClienteDto> adicionarCliente(@RequestBody ClienteForm clienteForm) throws Exception;

    @GetMapping
    ResponseEntity<List<ClienteDto>> listarClientes() throws Exception;

    @GetMapping("/{id}")
    ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable String id) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<ClienteDto> alterarDadosCliente(@PathVariable String id, @RequestBody ClienteAtualizacaoForm form) throws Exception;

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable String id) throws Exception;

}
