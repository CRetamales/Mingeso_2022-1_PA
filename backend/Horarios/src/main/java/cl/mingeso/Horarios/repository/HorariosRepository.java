package cl.mingeso.Horarios.repository;

import cl.mingeso.Horarios.entity.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface HorariosRepository extends JpaRepository<Horarios, Long> {
    public List<Horarios> findByFecha(Date fecha);
    @Query(value = "SELECT * FROM horarios WHERE  hora_ingreso = ?1", nativeQuery = true)
    public List<Horarios> findByHora_ingreso(Time hora_ingreso);

    @Query(value = "SELECT * FROM horarios WHERE  hora_salida = ?1", nativeQuery = true)
    public List<Horarios> findByHora_salida(Time hora_salida);

    @Query(value = "SELECT * FROM horarios WHERE  id_empleado = ?1", nativeQuery = true)
    public List<Horarios> findById_empleado(Long id_empleado);

    @Query(value = "SELECT * FROM horarios WHERE  fecha = ?1 AND id_empleado = ?2", nativeQuery = true)
    public List<Horarios> findByFechaAndId_empleado(Date fecha, Long id_empleado);




}
