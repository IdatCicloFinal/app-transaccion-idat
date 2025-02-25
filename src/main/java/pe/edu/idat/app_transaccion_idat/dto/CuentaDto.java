package pe.edu.idat.app_transaccion_idat.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CuentaDto {
    private Integer id;
    private String cuenta;
}
