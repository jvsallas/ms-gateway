package br.com.mercadosallas.service;

import br.com.mercadosallas.dto.ClienteAtualizacaoForm;
import br.com.mercadosallas.dto.ClienteDto;
import br.com.mercadosallas.feign.client.ClienteClient;
import br.com.mercadosallas.gateway.clientes.dto.ClienteForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteClient clienteClient;

    public ResponseEntity<ClienteDto> adicionarCliente(ClienteForm clienteForm) throws Exception {
        return clienteClient.adicionarCliente(clienteForm);
    }

    public ResponseEntity<List<ClienteDto>> listarClientes() throws Exception {
        return clienteClient.listarClientes();
    }

    public ResponseEntity<ClienteDto> buscarClientePorId(String id) throws Exception {
        return clienteClient.buscarClientePorId(id);
    }

    public ResponseEntity<ClienteDto> alterarDadosCliente(String id, ClienteAtualizacaoForm form) throws Exception {
        return clienteClient.alterarDadosCliente(id, form);
    }

    public void deletarCliente(String id) throws Exception {
        clienteClient.deletarCliente(id);
    }
}