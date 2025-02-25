package pe.edu.idat.app_transaccion_idat.model;

import jakarta.persistence.*;

@Table(name = "cuenta")
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double saldo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
