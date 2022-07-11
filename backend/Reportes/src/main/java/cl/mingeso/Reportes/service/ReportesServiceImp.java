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
        return reportesRepository.findAll();
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
