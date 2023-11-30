/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entidades.Cliente;
import Repositorios.clienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteService implements baseService<Cliente>{
    @Autowired
    public clienteRepository clienteRepository;

    public clienteService(clienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    
    @Override
    @Transactional
    public List<Cliente> findAll() throws Exception {
        
        try{
            List<Cliente>entities = clienteRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
       
    }
    
    @Transactional
    @Override
    public Cliente findById(Long id) throws Exception {
       try{
           Optional<Cliente> entityOptional =  clienteRepository.findById(id);
       
       return entityOptional.get();
       }catch(Exception e){
           throw new Exception(e.getMessage());
       }
    }
    
    @Transactional
    @Override
    public Cliente save(Cliente entity) throws Exception {
        try {
            entity = clienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public Cliente update(long id, Cliente entity) throws Exception {
        try {
            Optional<Cliente> entityOptional = clienteRepository.findById(id);
            Cliente cliente = entityOptional.get();
            cliente= clienteRepository.save(cliente);
            return cliente;   
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    @Override
    public boolean delete(Long id) throws Exception {
        try {
             if(clienteRepository.existsById(id)){
                 clienteRepository.deleteById(id);
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
