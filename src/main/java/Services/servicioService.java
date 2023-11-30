package Services;

import Entidades.Servicio;
import Repositorios.servicioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioService implements baseService<Servicio> {
    @Autowired
    public servicioRepository ServicioRepository;

    public servicioService(servicioRepository ServicioRepository) {
        this.ServicioRepository = ServicioRepository;
    }
    
    
    @Override
    @Transactional
    public List<Servicio> findAll() throws Exception {
        
        try{
            List<Servicio>entities = ServicioRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Servicio findById(Long id) throws Exception {
       try{
           Optional<Servicio> entityOptional =  ServicioRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Servicio save(Servicio entity) throws Exception {
        try {
            entity = ServicioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Servicio update(long id, Servicio entity) throws Exception {
        try {
            Optional<Servicio> entityOptional = ServicioRepository.findById(id);
            Servicio servicio = entityOptional.get();
            servicio= ServicioRepository.save(servicio);
            return servicio;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(ServicioRepository.existsById(id)){
                 ServicioRepository.deleteById(id);
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
