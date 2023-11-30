/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.util.List;
import org.springframework.stereotype.Service;


public interface baseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public E save(E Entity) throws Exception;
    
    public E update(long id, E entity) throws Exception;
    
    public boolean delete(Long id) throws Exception;
    
    
}
