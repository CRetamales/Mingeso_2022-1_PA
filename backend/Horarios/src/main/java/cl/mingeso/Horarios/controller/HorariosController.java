package cl.mingeso.Horarios.controller;

import cl.mingeso.Horarios.entity.Horarios;
import cl.mingeso.Horarios.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

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
    public ResponseEntity<Horarios> createHorario(@RequestBody Horarios horario) {
        Horarios horarioNuevo = horariosService.createHorario(horario);
        if(horarioNuevo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarioNuevo);
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



}
