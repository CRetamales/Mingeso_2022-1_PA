package cl.mingeso.Reportes.entity;

import cl.mingeso.Reportes.model.Empleados;
import cl.mingeso.Reportes.model.Horarios;
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
     * //No son guardados en la DB reportes, pero son consumidos por el frontend para mostrar los datos
     * @param Empleado - @OneToOne - Empleados - empleado que genera el reporte
     * @param Horarios - @OneToMany - List<Horarios> - lista de horarios asociado al id del empleado que genera el reporte
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Transient
    private Empleados empleado;

    @Transient
    private List<Horarios> horarios;




}
