package pe.edu.idat.app_transaccion_idat.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "transaccion")
@Entity
public class Transaccion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cuentaorigenid;
    private Integer cuentadestinoid;
    private Double monto;
    private LocalDateTime fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuentaorigenid() {
        return cuentaorigenid;
    }

    public void setCuentaorigenid(Integer cuentaorigenid) {
        this.cuentaorigenid = cuentaorigenid;
    }

    public Integer getCuentadestinoid() {
        return cuentadestinoid;
    }

    public void setCuentadestinoid(Integer cuentadestinoid) {
        this.cuentadestinoid = cuentadestinoid;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
