package pe.edu.idat.app_transaccion_idat.service;

import pe.edu.idat.app_transaccion_idat.dto.CuentaDto;
import pe.edu.idat.app_transaccion_idat.dto.TransaccionDto;

import java.util.List;

public interface ICuentaService {

    List<CuentaDto> listaCuentas();
    void transferir(TransaccionDto transaccionDto);
}
