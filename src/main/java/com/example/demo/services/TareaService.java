package com.example.demo.services;

import com.example.demo.entities.Tarea;

import java.util.List;

public interface TareaService {
    public List<Tarea> findAll();
    public Tarea findById(Long id);
    public void create(Tarea tarea);
    public void update(Long id, Tarea tarea);
    public void delete(Long id);
}
