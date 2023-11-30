
package Repositorios;

import Entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface servicioRepository extends JpaRepository<Servicio,Long>
{
    
}
