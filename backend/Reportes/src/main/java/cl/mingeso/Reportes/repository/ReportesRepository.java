package cl.mingeso.Reportes.repository;

import cl.mingeso.Reportes.entity.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Long> {

}
