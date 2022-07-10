package cl.mingeso.Horarios.repository;

import cl.mingeso.Horarios.entity.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface HorariosRepository extends JpaRepository<Horarios, Long> {
    public List<Horarios> findByFecha(Date fecha);
}
