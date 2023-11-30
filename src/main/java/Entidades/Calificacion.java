package Entidades;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
public class Calificacion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "estrellas")
    private String estrellas;

    @Column(name = "opinion")
    private String opinion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_ClienteCalificacion")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_PrestadorCalificacion")
    private Prestador prestador;

    public Calificacion(String estrellas, String opinion) {
        this.estrellas = estrellas;
        this.opinion = opinion;
        
    }

    

    public Calificacion() {
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    
    
}
