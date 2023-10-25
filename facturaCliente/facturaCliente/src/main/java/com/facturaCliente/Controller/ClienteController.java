package com.facturaCliente.Controller;

import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Exception.*;
import com.facturaCliente.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/clientes")
    public ResponseEntity<String>addClient(@RequestBody ClienteInput clienteInput){
        try{
            clienteService.addCliente(Cliente.getCliente(clienteInput));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (ClientExistsException e){
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }
    @PostMapping("/clientes/{clienteDni}/facturas")
    public ResponseEntity<String> addFacturaToCliente(@PathVariable String clienteDni, @RequestBody FacturaInput facturaInput) {
        try {
            clienteService.addFacturaToCliente(facturaInput.getCodFra(), clienteDni);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ClientDoesntExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (FacturaDoesntExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (FacturaAlreadyAssignedException e) {
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }
    }
    @GetMapping("clientes")
    public ResponseEntity<List<ClienteDniNombreOutput>>listClienteByTipoAndCountry(@RequestParam (name = "premium")Boolean premium,@RequestParam(name = "pais")String pais){
        try {
            List<ClienteDniNombreOutput> clientes = clienteService.listClienteByPremiumAndPais(premium, pais);
            return ResponseEntity.ok(clientes);
        }catch (ClientDoesntExistException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (InvalidFieldException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }
}
