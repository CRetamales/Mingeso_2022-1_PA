package cl.mingeso.Horarios.service;

import cl.mingeso.Horarios.entity.Horarios;
import cl.mingeso.Horarios.repository.HorariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorariosServiceImp implements HorariosService{

    @Autowired
    private HorariosRepository horariosRepository;

    @Override
    public List<Horarios> listAllHorarios() {
        return horariosRepository.findAll();
    }

    @Override
    public Horarios getHorarioById(Long id) {
        return horariosRepository.findById(id).orElse(null);
    }

    @Override
    public Horarios createHorario(Horarios horario) {
        return horariosRepository.save(horario);

    }

    @Override
    public Horarios updateHorario(Horarios horario) {
        Horarios horarioNuevo = getHorarioById(horario.getId());
        if(horarioNuevo != null){
            horarioNuevo.setFecha(horario.getFecha());
            horarioNuevo.setHora_ingreso(horario.getHora_ingreso());
            horarioNuevo.setHora_salida(horario.getHora_salida());
            //horarioNuevo.setId_empleado(horario.getId_empleado());
            return horariosRepository.save(horarioNuevo);
        }
        return null;
    }

    @Override
    public void deleteHorario(Long id) {
        Horarios horarioEliminar = getHorarioById(id);
        if(horarioEliminar != null){
            horariosRepository.delete(horarioEliminar);
        }
        return;

    }

    @Override
    public List<Horarios> findByFecha(Date fecha) {
        return horariosRepository.findByFecha(fecha);
    }
}
