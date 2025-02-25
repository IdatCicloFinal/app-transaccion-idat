package pe.edu.idat.app_transaccion_idat.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.edu.idat.app_transaccion_idat.dto.CuentaDto;
import pe.edu.idat.app_transaccion_idat.dto.TransaccionDto;
import pe.edu.idat.app_transaccion_idat.model.Cuenta;
import pe.edu.idat.app_transaccion_idat.model.Transaccion;
import pe.edu.idat.app_transaccion_idat.repository.CuentaRepository;
import pe.edu.idat.app_transaccion_idat.repository.TransaccionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public CuentaService(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<CuentaDto> listaCuentas() {
        return null;
    }

    //@org.springframework.transaction.annotation.Transactional()
    @Transactional
    @Override
    public void transferir(TransaccionDto transaccionDto) {
        Cuenta cuentaOrigen = cuentaRepository
                .findById(transaccionDto.getCuentaorigenid())
                .orElseThrow(()
                        -> new RuntimeException("Cuenta Origen no existe"));
        Cuenta cuentaDestino = cuentaRepository
                .findById(transaccionDto.getCuentadestinoid())
                .orElseThrow(()
                        -> new RuntimeException("Cuenta Destino no existe"));
        if(cuentaOrigen.getSaldo() < transaccionDto.getMonto()){
            throw new RuntimeException("Saldo Insuficiente");
        }
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() -
                transaccionDto.getMonto());
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() +
                transaccionDto.getMonto());
        //actualizando los montos de las cuentas
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
        //Creando la nueva transaccion generada
        Transaccion nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setCuentaorigenid(transaccionDto
                .getCuentaorigenid());
        nuevaTransaccion.setCuentadestinoid(transaccionDto
                .getCuentadestinoid());
        nuevaTransaccion.setFecha(LocalDateTime.now());
        nuevaTransaccion.setMonto(transaccionDto.getMonto());
        transaccionRepository.save(nuevaTransaccion);


    }
}
