package cl.mingeso.Horarios.controller;

import cl.mingeso.Horarios.entity.Horarios;
import cl.mingeso.Horarios.service.HorariosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/horarios")
public class HorariosController {

    @Autowired
    private HorariosService horariosService;

    @GetMapping
    public ResponseEntity<List<Horarios>> listAllHorarios() {
       List<Horarios> horarios = horariosService.listAllHorarios();
       if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(horarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Horarios> getHorarioById(@PathVariable Long id) {
        Horarios horario = horariosService.getHorarioById(id);
        if(horario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(horario);
    }

    @PostMapping
    public ResponseEntity<Horarios> createHorario(@Valid @RequestBody Horarios horario, BindingResult result) {
        if(result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Horarios horarioNuevo = horariosService.createHorario(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioNuevo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Horarios> updateHorario(@PathVariable Long id, @RequestBody Horarios horario) {
        Horarios horarioNuevo = horariosService.updateHorario(horario);
        if(horarioNuevo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(horarioNuevo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        Horarios horarioEliminar = horariosService.getHorarioById(id);
        if(horarioEliminar == null) {
            return ResponseEntity.notFound().build();
        }
        horariosService.deleteHorario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/fecha/{fecha}")
    public ResponseEntity<List<Horarios>> findByFecha(@PathVariable Date fecha) {
        List<Horarios> horarios = horariosService.findByFecha(fecha);
        if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }

    @GetMapping(value = "/hora_ingreso/{hora_ingreso}")
    public ResponseEntity<List<Horarios>> findByHora_ingreso(@PathVariable Time hora_ingreso) {
        List<Horarios> horarios = horariosService.findByHora_ingreso(hora_ingreso);
        if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }

    @GetMapping(value = "/hora_salida/{hora_salida}")
    public ResponseEntity<List<Horarios>> findByHora_salida(@PathVariable Time hora_salida) {
        List<Horarios> horarios = horariosService.findByHora_salida(hora_salida);
        if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }

    @GetMapping(value = "/id_empleado/{id_empleado}")
    public ResponseEntity<List<Horarios>> findById_empleado(@PathVariable Long id_empleado) {
        List<Horarios> horarios = horariosService.findById_empleado(id_empleado);
        if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
    }

    @GetMapping(value = "/fecha/{fecha}/id_empleado/{id_empleado}")
    public ResponseEntity<List<Horarios>> findByFechaAndId_empleado(@PathVariable Date fecha, @PathVariable Long id_empleado) {
        List<Horarios> horarios = horariosService.findByFechaAndId_empleado(fecha, id_empleado);
        if(horarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarios);
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
