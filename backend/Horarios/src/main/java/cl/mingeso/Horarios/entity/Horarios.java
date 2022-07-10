package cl.mingeso.Horarios.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity(name = "Horarios")
@Table(name = "horarios")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Horarios {

    /** Atributos de la clase Horarios
     * @param id - @Id - @GeneratedValue - Long - id del horario
     * @param fecha - @Date - Date - fecha del horario - YYYY-MM-DD
     * @param hora_ingreso - @Date - Date - hora de ingreso del horario - HH:MM:SS
     * @param hora_salida - @Date - Date - hora de salida del horario
     * @param id_empleado - @Long - Long - id del empleado que trabaja en el horario -
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private Date fecha;


    @Column(name = "hora_ingreso")
    private Time hora_ingreso;


    @Column(name = "hora_salida")
    private Time hora_salida;


    @Column(name = "id_empleado")
    private Long id_empleado;

}
