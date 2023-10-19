package com.facturaCliente.Service;

import com.facturaCliente.Controller.ClienteInput;
import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Domain.Factura;
import com.facturaCliente.Exception.ClientDoesntExistException;
import com.facturaCliente.Exception.ClientExistsException;
import com.facturaCliente.Exception.FacturaDoesntExistException;
import com.facturaCliente.Exception.FacturaExistsException;
import com.facturaCliente.Repository.ClienteRepository;
import com.facturaCliente.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    public void addCliente(ClienteInput clienteInput) throws ClientExistsException {
        if(clienteRepository.existsById(clienteInput.getDni()))
            throw new ClientExistsException("El cliente ya existe");
        Cliente cliente = new Cliente(clienteInput.getDni(),clienteInput.getNombre(),clienteInput.getPais(),clienteInput.isPremium(),clienteInput.getFechaNac());
        clienteRepository.save(cliente);
    }
    public void addFacturaToCliente(int codFra,String dni) throws ClientDoesntExistException,FacturaDoesntExistException,FacturaExistsException{
        Cliente cliente = clienteRepository.findById(dni).orElse(null);
        if(cliente == null){
            throw new ClientDoesntExistException("El cliente con dni " + dni + " no exisite");
        }
        Factura factura = facturaRepository.findById(codFra).orElse(null);
        if(factura == null){
            throw new FacturaDoesntExistException("La factura con codigo " + codFra + " no existe");
        }
        if(factura.getClienteDni() != null){
            throw new FacturaExistsException("La factura con codigo " + codFra + " ya está agregada al cliente");
        }
        factura.setClienteDni(dni);
        facturaRepository.save(factura);
    }

}
