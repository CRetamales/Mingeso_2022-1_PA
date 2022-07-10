package cl.mingeso.Empleados.repository;

import cl.mingeso.Empleados.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

    public List<Empleados> findByNombre(String nombre);
    public List<Empleados> findByCategoria(String categoria);

}
