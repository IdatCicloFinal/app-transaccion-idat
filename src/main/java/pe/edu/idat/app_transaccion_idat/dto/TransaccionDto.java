package pe.edu.idat.app_transaccion_idat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransaccionDto {
    private Integer cuentaorigenid;
    private Integer cuentadestinoid;
    private Double monto;
}
