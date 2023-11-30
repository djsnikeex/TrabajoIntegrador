package Entidades;


import Entidades.Contrato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
public class Tarea implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descripcionTarea")
    private String descripcionTarea;

    @ManyToOne
    @JoinColumn(name = "contratoTareaFK")
    private Contrato contrato;
    
    @ManyToOne
    @JoinColumn(name = "servicioTareaFK")
    private Servicio servicio;

    public Tarea() {
    }

    public Tarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
    
}