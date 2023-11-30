
package Repositorios;

import Entidades.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface calificacionRepository extends JpaRepository<Calificacion,Long> {
    
}
