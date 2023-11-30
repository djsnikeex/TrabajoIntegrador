package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table

public class Usuario implements Serializable{
    private static final long SerialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idU;
    @Column(name="nombreU")
    private String nombreU;
    @Column(name="apellidoU")
    private String apellidoU;

    @Column(name="dniU")
    private  String dniU;

    public Usuario() {
    }

    public Usuario(String nombreU, String apellidoU, String dniU) {
        this.nombreU = nombreU;
        this.apellidoU = apellidoU;
        this.dniU = dniU;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getApellidoU() {
        return apellidoU;
    }

    public void setApellidoU(String apellidoU) {
        this.apellidoU = apellidoU;
    }

    public String getDniU() {
        return dniU;
    }

    public void setDniU(String dniU) {
        this.dniU = dniU;
    }
    
    
}
