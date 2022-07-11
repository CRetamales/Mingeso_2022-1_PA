package cl.mingeso.Reportes.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleados {
    private Long id;
    private String nombre;
    private String categoria;
}
