
package Controller;

import Entidades.Cliente;
import Services.clienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
@RequestMapping(path = "/api/v1/Cliente")
public class ClienteController {
    private clienteService ClienteService;
    
    public ClienteController(clienteService ClienteService){
        this.ClienteService = ClienteService;
    }
    
    
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ClienteService.findAll());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ClienteService.findById(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    
    @PostMapping("")
    public ResponseEntity <?> save(@RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ClienteService.save(entity));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity <?> update(@PathVariable Long id, @RequestBody Cliente entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ClienteService.update(id,entity));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ClienteService.delete(id));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde. \"}");
        }
    }
    
}
