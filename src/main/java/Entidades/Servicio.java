package Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Servicio implements Serializable {
    @Serial
   private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="descripcion")
    private String descripcion;
    
    
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;

    @OneToMany
    @JoinColumn(name = "tarea_id")
    private List<Tarea> tarea;
    
    public Servicio(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio() {
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
