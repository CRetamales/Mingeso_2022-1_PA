package cl.mingeso.Reportes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "reportes")
public class Reportes {
    /** Atributos de la clase Reportes
     * @param id - @Id - @GeneratedValue - Long - id del reporte
     * @param Empleados - @OneToMany - List<Empleados> - lista de empleados que trabajan en el reporte
     * @param Horarios - @OneToMany - List<Horarios> - lista de horarios que trabajan en el reporte
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






}
