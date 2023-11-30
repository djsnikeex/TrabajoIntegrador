/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entidades.Calificacion;
import Services.calificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Calificacion")
public class CalificacionController {
    private calificacionService CalificacionService;
    
    public CalificacionController(calificacionService CalificacionService){
        this.CalificacionService = CalificacionService;
    }
    
    
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(CalificacionService.findAll());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(CalificacionService.findById(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    
    @PostMapping("")
    public ResponseEntity <?> save(@RequestBody Calificacion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(CalificacionService.save(entity));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <?> update(@PathVariable Long id, @RequestBody Calificacion entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(CalificacionService.update(id,entity));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(CalificacionService.delete(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
}
