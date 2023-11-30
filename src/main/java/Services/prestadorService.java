
package Services;

import Entidades.Prestador;
import Repositorios.prestadorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class prestadorService implements baseService<Prestador>{
    @Autowired
    public prestadorRepository prestadorRepository;

    public prestadorService(prestadorRepository prestadorRepository) {
        this.prestadorRepository = prestadorRepository;
    }
    
    
    @Override
    @Transactional
    public List<Prestador> findAll() throws Exception {
        
        try{
            List<Prestador>entities = prestadorRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Prestador findById(Long id) throws Exception {
       try{
           Optional<Prestador> entityOptional =  prestadorRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Prestador save(Prestador entity) throws Exception {
        try {
            entity = prestadorRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Prestador update(long id, Prestador entity) throws Exception {
        try {
            Optional<Prestador> entityOptional = prestadorRepository.findById(id);
            Prestador prestador = entityOptional.get();
            prestador= prestadorRepository.save(prestador);
            return prestador;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(prestadorRepository.existsById(id)){
                 prestadorRepository.deleteById(id);
                 return true;
             }
             else{
                 throw new Exception();
             }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }
}
