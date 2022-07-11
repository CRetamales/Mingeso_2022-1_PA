package cl.mingeso.Reportes.client;

import cl.mingeso.Reportes.model.Empleados;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "Empleados", fallback = EmpleadosHystrixFallbackFactory.class)
public interface EmpleadosClient {
    @GetMapping(value = "/empleados/{id}")
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable Long id);
}
