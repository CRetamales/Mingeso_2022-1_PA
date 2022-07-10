package cl.mingeso.Horarios.controller;

import cl.mingeso.Horarios.entity.Horarios;
import cl.mingeso.Horarios.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Horarios> createHorario(@RequestBody Horarios horario) {
        Horarios horarioNuevo = horariosService.createHorario(horario);
        if(horarioNuevo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(horarioNuevo);
    }


}
