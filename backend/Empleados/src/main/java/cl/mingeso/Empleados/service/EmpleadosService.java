package cl.mingeso.Empleados.service;

import cl.mingeso.Empleados.entity.Empleados;

import java.util.List;

public interface EmpleadosService {
    //CRUD
    //READ ALL empleados
    public List<Empleados> listAllEmpleados();
    public Empleados getEmpleadoById(Long id);
    //CREATE empleado
    public Empleados createEmpleado(Empleados empleado);
    //UPDATE empleado
    public Empleados updateEmpleado(Empleados empleado);
    //DELETE empleado
    public void deleteEmpleado(Long id);

    //Otros metodos
    public List<Empleados> findByNombre(String nombre);
    public List<Empleados> findByCategoria(String categoria);



}

