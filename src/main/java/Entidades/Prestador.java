package Entidades;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Prestador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private  String dni;
    
    @Column(name = "horario")
    private String horario;

    @Column(name = "zonaCobertura")
    private String zonaCobertura;

    @OneToMany(mappedBy= "prestador")
    private List<Calificacion> cali;
    
    @OneToMany(mappedBy = "prestador")
    private List<Servicio> servicios;
    
    @OneToMany(mappedBy = "prestador")
    private List<Contrato> contratos;

    public Prestador() {
    }

    public Prestador(String nombre, String apellido, String dni, String horario, String zonaCobertura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.horario = horario;
        this.zonaCobertura = zonaCobertura;
    }

    public List<Calificacion> getCali() {
        return cali;
    }

    public void setCali(List<Calificacion> cali) {
        this.cali = cali;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    

   
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }



    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }

}