package cl.mingeso.Reportes.controller;


import cl.mingeso.Reportes.entity.Reportes;
import cl.mingeso.Reportes.service.ReportesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Slf4j
@RestController
@RequestMapping("/reportes")
public class ReportesContoller {

    @Autowired
    ReportesService reportesService;

    @GetMapping
    public ResponseEntity<List<Reportes>> listAllReportes() {
        List<Reportes> reportes = reportesService.listAllReportes();
        if(reportes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reportes> getReporteById(@PathVariable Long id) {
        Reportes reporte = reportesService.getReporteById(id);
        if(reporte == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reporte);
    }

    @PostMapping
    public ResponseEntity<Reportes> createReporte(@Valid @RequestBody Reportes reporte, BindingResult result) {
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Reportes reporteNuevo = reportesService.createReporte(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(reporteNuevo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reportes> updateReporte(@PathVariable Long id, @RequestBody Reportes reporte) {
        Reportes reporteNuevo = reportesService.updateReporte(reporte);
        if(reporteNuevo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reporteNuevo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        Reportes reporteeliminar = reportesService.getReporteById(id);
        if(reporteeliminar == null){
            return ResponseEntity.notFound().build();
        }
        reportesService.deleteReporte(id);
        return ResponseEntity.ok().build();
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
