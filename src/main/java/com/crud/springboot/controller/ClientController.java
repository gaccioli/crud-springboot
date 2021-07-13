package com.crud.springboot.controller;



import com.crud.springboot.model.Client;
import com.crud.springboot.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping({"/client"})
public class ClientController {

    private ClientRepository repository;

    /*
    ClientController(ClientRepository clientRepository){
        this.repository = clientRepository;
    }*/

    @GetMapping
    public List getAllClient(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getClientById(@PathVariable Long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return repository.save(client);
    }

    @DeleteMapping(path = "/{id}")
        public ResponseEntity <?> deleteClient(@PathVariable Long id){
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody Client client){
        return repository.findById(id)
                .map(record -> {
                    record.setNome(client.getNome());
                    record.setEmail(client.getEmail());
                    record.setCpf(client.getCpf());
                    record.setTelefone(client.getTelefone());
                    record.setStatus(client.getStatus());
                    Client updateClient = repository.save(record);
                    return ResponseEntity.ok().body(updateClient);
                }).orElse(ResponseEntity.notFound().build());

    }


}
