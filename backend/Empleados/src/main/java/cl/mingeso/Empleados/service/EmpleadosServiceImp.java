package cl.mingeso.Empleados.service;


import cl.mingeso.Empleados.entity.Empleados;
import cl.mingeso.Empleados.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadosServiceImp implements EmpleadosService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> listAllEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleados getEmpleadoById(Long id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados createEmpleado(Empleados empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public Empleados updateEmpleado(Empleados empleado) {
        Empleados empleadoNuevo = getEmpleadoById(empleado.getId());
        if(empleadoNuevo != null){
            empleadoNuevo.setNombre(empleado.getNombre());
            empleadoNuevo.setCategoria(empleado.getCategoria());
            return empleadosRepository.save(empleadoNuevo);
        }
        return null;
    }

    @Override
    public void deleteEmpleado(Long id) {
        Empleados empleadoEliminar = getEmpleadoById(id);
        if(empleadoEliminar != null){
            empleadosRepository.delete(empleadoEliminar);
        }
        return;
    }

    @Override
    public List<Empleados> findByNombre(String nombre) {
        return empleadosRepository.findByNombre(nombre);
    }

    @Override
    public List<Empleados> findByCategoria(String categoria) {
        return empleadosRepository.findByCategoria(categoria);
    }

}
