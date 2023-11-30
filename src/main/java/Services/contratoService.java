package Services;


import Entidades.Contrato;
import Repositorios.contratoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contratoService implements baseService<Contrato> {
    @Autowired
    public contratoRepository ContratoRepository;

    public contratoService(contratoRepository ContratoRepository) {
        this.ContratoRepository = ContratoRepository;
    }
    
    
    @Override
    @Transactional
    public List<Contrato> findAll() throws Exception {
        
        try{
            List<Contrato>entities = ContratoRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Contrato findById(Long id) throws Exception {
       try{
           Optional<Contrato> entityOptional =  ContratoRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Contrato save(Contrato entity) throws Exception {
        try {
            entity = ContratoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Contrato update(long id, Contrato entity) throws Exception {
        try {
            Optional<Contrato> entityOptional = ContratoRepository.findById(id);
            Contrato contrato = entityOptional.get();
            contrato= ContratoRepository.save(contrato);
            return contrato;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(ContratoRepository.existsById(id)){
                 ContratoRepository.deleteById(id);
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
