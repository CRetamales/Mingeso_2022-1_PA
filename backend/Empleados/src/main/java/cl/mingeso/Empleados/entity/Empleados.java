package cl.mingeso.Empleados.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity(name = "Empleados")
@Table(name = "empleados")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Empleados {
    /** Atributos de la clase Empleados
     * @param id - @Id - @GeneratedValue - Long - id del empleado
     * @param nombre - @String - String - nombre del empleado
     * @param categoria - @String - String - categoria del empleado
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty(message = "La categoria no puede estar vacia")
    @Column(name = "categoria")
    private String categoria;


}
