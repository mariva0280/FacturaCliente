package com.facturaCliente.Repository;

import com.facturaCliente.Controller.ClienteDniNombreOutput;
import com.facturaCliente.Domain.Cliente;
import com.facturaCliente.Domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    List<Cliente>findByPremiumAndPaisOrderByNombre(Boolean premium,String pais);
}
