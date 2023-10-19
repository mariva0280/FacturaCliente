package com.facturaCliente.Repository;

import com.facturaCliente.Domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    List<Factura> findByClienteDni(String clienteDni);
    List<Factura> findAllByAnyoAndMes(int anyo, String mes);
}
