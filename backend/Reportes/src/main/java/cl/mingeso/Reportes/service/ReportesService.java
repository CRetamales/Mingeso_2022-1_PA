package cl.mingeso.Reportes.service;

import cl.mingeso.Reportes.entity.Reportes;

import java.util.List;

public interface ReportesService {
    //CRUD
    //READ ALL reportes
    public List<Reportes> listAllReportes();
    public Reportes getReporteById(Long id);
    //CREATE reporte
    public Reportes createReporte(Reportes reporte);
    //UPDATE reporte
    public Reportes updateReporte(Reportes reporte);
    //DELETE reporte
    public void deleteReporte(Long id);

}
