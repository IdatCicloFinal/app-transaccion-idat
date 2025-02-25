package pe.edu.idat.app_transaccion_idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.app_transaccion_idat.model.Cuenta;

@Repository
public interface CuentaRepository
        extends JpaRepository<Cuenta, Integer> {

}
