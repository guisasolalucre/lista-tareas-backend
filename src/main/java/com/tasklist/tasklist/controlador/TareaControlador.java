
package com.tasklist.tasklist.controlador;

import com.tasklist.tasklist.modelo.Tarea;
import com.tasklist.tasklist.servicios.TareaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class TareaControlador {

    @Autowired
    private TareaServicio tareaServicio;
    
    //listar tareas
    @GetMapping("/tareas")
    public List<Tarea> listar(){
        return tareaServicio.findAll();
    }
    
    //guardar
    @PostMapping("/tareas")
    public void guardar(@RequestBody Tarea tarea){
        tareaServicio.save(tarea);
    }
    
    //get by id
    @GetMapping("/tareas/{id}")
    public Tarea getById(@PathVariable Long id){
        return tareaServicio.getById(id);
    }
    
    //editar
    @PutMapping("/tareas/{id}")
    public void editar(@PathVariable Long id,
                       @RequestBody Tarea tarea){
        Tarea actual = tareaServicio.getById(id);
        actual.setText(tarea.getText());
        actual.setDay(tarea.getDay());
        actual.setReminder(tarea.getReminder());
        tareaServicio.save(actual);
    }
    
    @DeleteMapping("/tareas/{id}")
    public void eliminar(@PathVariable Long id){
        tareaServicio.deleteById(id);
    }

    
}
