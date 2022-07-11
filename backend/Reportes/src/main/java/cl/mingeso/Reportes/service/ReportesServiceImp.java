package cl.mingeso.Reportes.service;


import cl.mingeso.Reportes.entity.Reportes;
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

    //@Autowired
    //EmpleadosClient empleadosClient;

    //@Autowired
    //HorariosClient horariosClient;

    @Override
    public List<Reportes> listAllReportes() {
        return reportesRepository.findAll();
    }

    @Override
    public Reportes getReporteById(Long id) {
        return reportesRepository.findById(id).orElse(null);
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
