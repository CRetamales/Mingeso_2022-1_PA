package cl.mingeso.Reportes.client;

import cl.mingeso.Reportes.model.Horarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "Horarios")
@RequestMapping(value = "/horarios")
public interface HorariosClient {

    @GetMapping(value = "/id_empleado/{id_empleado}")
    public ResponseEntity<List<Horarios>> findById_empleado(@PathVariable Long id_empleado);
}
