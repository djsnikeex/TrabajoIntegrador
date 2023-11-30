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
public class Contrato implements Serializable{
    @Serial
    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="fecha")
    private String fecha;
    
    @Column(name="horario")
    private String horario;
    
    @Column(name="precio")
    private String precio;
    
    @Column(name="finalizado")
    private int finalizado;
    
    @ManyToOne
    @JoinColumn(name = "clienteCon_FK")
    private Cliente cli;
    
    @ManyToOne
    @JoinColumn(name = "prestadorCon_FK")
    private Prestador prestador;
    
    @OneToMany
    @JoinColumn(name = "tareaCon_FK")
    private List<Tarea> tarea;

    public Contrato() {
    }
     
    

    public Contrato(String fecha, String horario, String precio, int finalizado) {
        this.fecha = fecha;
        this.horario = horario;
        this.precio = precio;
        this.finalizado = finalizado;
    }

    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

   
   
    
    
    
}
