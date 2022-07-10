package cl.mingeso.Horarios.service;

import cl.mingeso.Horarios.entity.Horarios;

import java.sql.Date;
import java.util.List;

public interface HorariosService {
    public List<Horarios> listAllHorarios();
    public Horarios getHorarioById(Long id);
    public Horarios createHorario(Horarios horario);
    public Horarios updateHorario(Horarios horario);
    public void deleteHorario(Long id);
    public List<Horarios> findByFecha(Date fecha);
}
