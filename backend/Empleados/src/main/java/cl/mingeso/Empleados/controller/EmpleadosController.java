package cl.mingeso.Empleados.controller;

import cl.mingeso.Empleados.entity.Empleados;
import cl.mingeso.Empleados.service.EmpleadosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping
    public ResponseEntity<List<Empleados>> listAllEmpleados() {
        List<Empleados> empleados = empleadosService.listAllEmpleados();
        if(empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable Long id) {
        Empleados empleado = empleadosService.getEmpleadoById(id);
        if(empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping
    public ResponseEntity<Empleados> createEmpleado(@Valid @RequestBody Empleados empleado, BindingResult result) {
        if(result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Empleados empleadoNuevo = empleadosService.createEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoNuevo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empleados> updateEmpleado(@PathVariable Long id, @RequestBody Empleados empleado) {
        Empleados empleadoNuevo = empleadosService.updateEmpleado(empleado);
        if(empleadoNuevo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleadoNuevo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        Empleados empleadoEliminar = empleadosService.getEmpleadoById(id);
        if(empleadoEliminar == null) {
            return ResponseEntity.notFound().build();
        }
        empleadosService.deleteEmpleado(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/nombre/{nombre}")
    public ResponseEntity<List<Empleados>> findByNombre(@PathVariable String nombre) {
        List<Empleados> empleados = empleadosService.findByNombre(nombre);
        if(empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping(value = "/categoria/{categoria}")
    public ResponseEntity<List<Empleados>> findByCategoria(@PathVariable String categoria) {
        List<Empleados> empleados = empleadosService.findByCategoria(categoria);
        if(empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
