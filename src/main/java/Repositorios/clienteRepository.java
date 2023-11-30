
package Repositorios;

import Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface clienteRepository extends JpaRepository <Cliente,Long>{
    
}
