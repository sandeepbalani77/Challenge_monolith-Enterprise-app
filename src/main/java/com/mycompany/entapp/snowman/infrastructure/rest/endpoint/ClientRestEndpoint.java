package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.exception.SnowmanException;
import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.ClientResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientRestEndpoint {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResource> getClient(@PathVariable int clientId) {
        Client client = clientService.getClient(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ClientResourceMapper.mapToClientResource(client));
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createClient(@RequestBody ClientResource clientResource) throws SnowmanException {
        clientService.createClient(ClientResourceMapper.mapToClient(clientResource));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateClient(@RequestBody ClientResource clientResource) throws SnowmanException {
        clientService.updateClient(ClientResourceMapper.mapToClient(clientResource));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable int clientId) throws SnowmanException {
        clientService.deleteClient(clientId);
        return ResponseEntity.ok().build();
    }
}
