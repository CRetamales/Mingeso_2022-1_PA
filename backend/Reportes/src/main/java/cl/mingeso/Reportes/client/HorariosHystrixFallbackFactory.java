package cl.mingeso.Reportes.client;

import cl.mingeso.Reportes.model.Horarios;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class HorariosHystrixFallbackFactory implements HorariosClient {

    @Override
    public ResponseEntity<List<Horarios>> findById_empleado(@PathVariable Long id_empleado){
        Horarios horario = Horarios.builder()
                .id_empleado(0L)
                .fecha(null)
                .hora_ingreso(null)
                .hora_salida(null)
                .build();
        return ResponseEntity.ok(List.of(horario));
    }

}
