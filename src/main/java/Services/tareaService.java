/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entidades.Tarea;
import Repositorios.tareaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tareaService implements baseService<Tarea> {
    @Autowired
    public tareaRepository TareaRepository;

    public tareaService(tareaRepository TareaRepository) {
        this.TareaRepository = TareaRepository;
    }
    
    
    @Override
    @Transactional
    public List<Tarea> findAll() throws Exception {
        
        try{
            List<Tarea>entities = TareaRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Tarea findById(Long id) throws Exception {
       try{
           Optional<Tarea> entityOptional =  TareaRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Tarea save(Tarea entity) throws Exception {
        try {
            entity = TareaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Tarea update(long id, Tarea entity) throws Exception {
        try {
            Optional<Tarea> entityOptional = TareaRepository.findById(id);
            Tarea tarea = entityOptional.get();
            tarea = TareaRepository.save(tarea);
            return tarea;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(TareaRepository.existsById(id)){
                 TareaRepository.deleteById(id);
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
