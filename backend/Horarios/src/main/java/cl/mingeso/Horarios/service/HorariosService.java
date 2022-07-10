package cl.mingeso.Horarios.service;

import cl.mingeso.Horarios.entity.Horarios;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface HorariosService {
    //CRUD
    //READ ALL horarios
    public List<Horarios> listAllHorarios();
    public Horarios getHorarioById(Long id);
    //CREATE horario
    public Horarios createHorario(Horarios horario);
    //UPDATE horario
    public Horarios updateHorario(Horarios horario);
    //DELETE horario
    public void deleteHorario(Long id);

    //Otros metodos
    public List<Horarios> findByFecha(Date fecha);
    public List<Horarios> findByHora_ingreso(Time hora_ingreso);
    public List<Horarios> findByHora_salida(Time hora_salida);
    public List<Horarios> findById_empleado(Long id_empleado);
    public List<Horarios> findByFechaAndId_empleado(Date fecha, Long id_empleado);



}
