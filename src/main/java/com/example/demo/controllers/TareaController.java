package com.example.demo.controllers;

import com.example.demo.entities.Tarea;
import com.example.demo.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableSwagger2
@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping
    public List<Tarea> GetAll(){return tareaService.findAll();}

    @GetMapping(value = "/{id}")
    public Tarea GetById(@PathVariable Long id){return tareaService.findById(id);}

    @PostMapping
    public void Create(@RequestBody Tarea tarea){tareaService.create(tarea);}

    @PutMapping(value = "/{id}")
    public void Update(@PathVariable Long id, @RequestBody Tarea tarea){
        tareaService.update(id, tarea);
    }

    @DeleteMapping(value = "/{id}")
    public void Delete(@PathVariable Long id){tareaService.delete(id);}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
