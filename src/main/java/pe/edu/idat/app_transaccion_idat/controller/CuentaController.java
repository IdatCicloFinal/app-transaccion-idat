package pe.edu.idat.app_transaccion_idat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.app_transaccion_idat.dto.TransaccionDto;
import pe.edu.idat.app_transaccion_idat.service.ICuentaService;

@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentaController {
    private final ICuentaService iCuentaService;

    public CuentaController(ICuentaService iCuentaService) {
        this.iCuentaService = iCuentaService;
    }
    @PostMapping("/transaccion")
    public ResponseEntity<String> transaccion(
            @RequestBody TransaccionDto transaccionDto
            ){
        try{
            iCuentaService.transferir(transaccionDto);
            return new ResponseEntity<>("Transferencia correcta",
                    HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>("Error:"+
                    ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
