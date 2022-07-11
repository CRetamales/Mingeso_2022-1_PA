package cl.mingeso.Reportes.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class Horarios {
    private Long id;
    private Date fecha;
    private Time hora_ingreso;
    private Time hora_salida;
    private Long id_empleado;

}
