
package Repositorios;

import Entidades.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface prestadorRepository extends JpaRepository<Prestador,Long> {
    
}
