
package com.tasklist.tasklist.servicios;

import com.tasklist.tasklist.modelo.Tarea;
import com.tasklist.tasklist.repositorios.TareaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TareaServicio implements ITareaServicio{

    @Autowired
    private TareaRepositorio tareaRepo;

    @Override
    @Transactional(readOnly=true)
    public List<Tarea> findAll() {
        return tareaRepo.findAll();
    }

    @Override
    @Transactional(readOnly=false)
    public void save(Tarea tarea) {
        tareaRepo.save(tarea);
    }

    @Override
    @Transactional(readOnly=true)
    public Tarea getById(Long id) {
        return tareaRepo.findById(id).get();
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteById(Long id) {
        tareaRepo.deleteById(id);
    }

}
