package Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table
public class Cliente implements Serializable  {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private  String dni;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_ClienteCalificacion")
    private List<Calificacion> cal;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Cliente() {
    }

    
    

    public void Calificar(String estrellas, String opinion, Prestador prestador){
        Calificacion cali= new Calificacion(estrellas,opinion);
        cali.setPrestador(prestador);
        cali.setCliente(this);
        cal.add(cali);
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Calificacion> getCal() {
        return cal;
    }

    public void setCal(List<Calificacion> cal) {
        this.cal = cal;
    }

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
