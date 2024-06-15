package com.example.demo.services;

import com.example.demo.dao.TareaDao;
import com.example.demo.entities.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImp implements TareaService{
    @Autowired
    TareaDao tareaDao;
    @Override
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaDao.findAll();
    }

    @Override
    public Tarea findById(Long id) {
        return tareaDao.findById(id).orElse(null);
    }

    @Override
    public void create(Tarea tarea) {
        tareaDao.save(tarea);
    }

    @Override
    public void update(Long id, Tarea tarea) {
        if (tareaDao.existsById(id)) {
            tarea.setId(id);
            tareaDao.save(tarea);
        }
    }

    @Override
    public void delete(Long id) {
        if (tareaDao.existsById(id)) {
            tareaDao.deleteById(id);
        }
    }
}
