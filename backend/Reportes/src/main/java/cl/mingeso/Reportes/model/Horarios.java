package cl.mingeso.Reportes.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class Horarios {
    private Long id;
    private Date fecha;
    private Time hora_ingreso;
    private Time hora_salida;
    private Long id_empleado;

}
