
package Repositorios;

import Entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;


public interface tareaRepository  extends JpaRepository<Tarea,Long>{
    
}
