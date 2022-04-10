
package com.tasklist.tasklist.servicios;

import com.tasklist.tasklist.modelo.Tarea;
import java.util.List;

public interface ITareaServicio{

    public List<Tarea> findAll();
    public void save(Tarea tarea);
    public Tarea getById(Long id);
    public void deleteById(Long id);
    
}
