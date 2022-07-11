package cl.mingeso.Reportes.client;

import cl.mingeso.Reportes.model.Empleados;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class EmpleadosHystrixFallbackFactory implements EmpleadosClient{
    @Override
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable Long id){
        Empleados empleado = Empleados.builder()
                .nombre("Empleado no encontrado")
                .categoria("Categoria no encontrada")
                .build();
        return ResponseEntity.ok(empleado);
    }
}
