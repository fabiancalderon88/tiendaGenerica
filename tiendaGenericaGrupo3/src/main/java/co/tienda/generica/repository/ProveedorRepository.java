package co.tienda.generica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.tienda.generica.model.*;

@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor, Integer>{

}
