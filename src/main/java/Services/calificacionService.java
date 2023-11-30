/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entidades.Calificacion;
import Repositorios.calificacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class calificacionService implements baseService<Calificacion>{
    @Autowired

    public calificacionRepository caRepository;

    public calificacionService(calificacionRepository caRepository) {
        this.caRepository = caRepository;
    }
    
    
    @Override
    @Transactional
    public List<Calificacion> findAll() throws Exception {
        
        try{
            List<Calificacion>entities = caRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Calificacion findById(Long id) throws Exception {
       try{
           Optional<Calificacion> entityOptional =  caRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Calificacion save(Calificacion entity) throws Exception {
        try {
            entity = caRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Transactional
    @Override
    public Calificacion update(long id, Calificacion entity) throws Exception {
        try {
            Optional<Calificacion> entityOptional = caRepository.findById(id);
            Calificacion calificacion = entityOptional.get();
            calificacion= caRepository.save(calificacion);
            return calificacion;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(caRepository.existsById(id)){
                 caRepository.deleteById(id);
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
