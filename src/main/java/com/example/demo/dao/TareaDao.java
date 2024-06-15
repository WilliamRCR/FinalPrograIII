package com.example.demo.dao;

import com.example.demo.entities.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaDao extends CrudRepository <Tarea, Long> {
}
