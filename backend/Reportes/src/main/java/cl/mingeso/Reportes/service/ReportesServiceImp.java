package cl.mingeso.Reportes.service;


import cl.mingeso.Reportes.client.EmpleadosClient;
import cl.mingeso.Reportes.client.HorariosClient;
import cl.mingeso.Reportes.entity.Reportes;
import cl.mingeso.Reportes.model.Empleados;
import cl.mingeso.Reportes.model.Horarios;
import cl.mingeso.Reportes.repository.ReportesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
public class ReportesServiceImp implements ReportesService {

    @Autowired
    ReportesRepository reportesRepository;

    @Autowired
    EmpleadosClient empleadosClient;

    @Autowired
    HorariosClient horariosClient;

    @Override
    public List<Reportes> listAllReportes() {
        List<Reportes> reportes = reportesRepository.findAll();
        //Por cada reporte se le asigna el empleado y el horarios correspondiente
        for(Reportes reporte : reportes){
            Empleados empleado = empleadosClient.getEmpleadoById(reporte.getId()).getBody();
            reporte.setEmpleado(empleado);
            List<Horarios> horarios = horariosClient.findById_empleado(reporte.getId()).getBody();
            //Se calcula la cantidad de horas trabajadas de cada horario del reporte
            if (horarios != null) {
                for (Horarios horario : horarios) {
                    horario.setHoras_trabajadas(horario.getHoras_trabajadas());
                }
            }
            reporte.setHorarios(horarios);
        }

        return reportes;
    }

    @Override
    public Reportes getReporteById(Long id) {
        Reportes reporte = reportesRepository.findById(id).orElse(null);
        if(null != reporte){
            Empleados empleado = empleadosClient.getEmpleadoById(reporte.getId()).getBody();
            reporte.setEmpleado(empleado);
            List<Horarios> horarios = horariosClient.findById_empleado(empleado.getId()).getBody();
            reporte.setHorarios(horarios);
        }
        return reporte;
    }

    @Override
    public Reportes createReporte(Reportes reporte) {
        return reportesRepository.save(reporte);
    }

    @Override
    public Reportes updateReporte(Reportes reporte) {
        Reportes reporteNuevo = reportesRepository.findById(reporte.getId()).orElse(null);
        if(reporteNuevo != null){
            return reportesRepository.save(reporteNuevo);
        }
        return null;
    }

    @Override
    public void deleteReporte(Long id) {
        Reportes reporteEliminar = reportesRepository.findById(id).orElse(null);
        if(reporteEliminar != null){
            reportesRepository.delete(reporteEliminar);
        }
        return;
    }

}
