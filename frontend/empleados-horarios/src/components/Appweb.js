import React from 'react';
import Button from '@mui/material/Button';


export default function Appweb() {
  //Listado de empleados con el formato json de la base de datos ejemplo: 
  // [{id: 1,nombre:"Juan",categoria:"Administrativo"},{id: 2,nombre:"Pedro",categoria:"Administrativo"}]
  const[empleados,setEmpleados] = React.useState([]);

  //Listado de empleados + horarios con el formato json de la base de datos ejemplo:
  // [{id:1,empleado:{id:1,nombre:"Juan",categoria:"Administrativo"},horarios:[{id:1,fecha:"2020-01-01",hora_ingreso:"08:00:00",hora_salida:"12:00:00",id_empleado:"1",horas_trabajadas:"08:00:00"},{id:2,fecha:"2020-01-01",hora_ingreso:"13:00:00",hora_salida:"17:00:00",id_empleado:"1",horas_trabajadas:"04:00:00"}]},{id:2,empleado:{id:2,nombre:"Pedro",categoria:"Administrativo"},horarios:[{id:3,fecha:"2020-01-01",hora_ingreso:"08:00:00",hora_salida:"12:00:00",id_empleado:"2",horas_trabajadas:"08:00:00"},{id:4,fecha:"2020-01-01",hora_ingreso:"13:00:00",hora_salida:"17:00:00",id_empleado:"2",horas_trabajadas:"04:00:00"}]}]
  const[empleadosHorarios,setEmpleadosHorarios] = React.useState([]);


  return (
    //Un container para el Appweb que contiene dos botones
    //Un boton para cargar los empleados
    //Un boton para cargar los empleados con sus horarios
    //Usando axios
    
    <div className="App">
      <Button variant="contained" color="primary" onClick={()=>{
        //Cargar los empleados
        fetch('/empleados')
        .then(response => response.json())
        .then(data => {
          setEmpleados(data);
        }).catch(error => {
          console.log(error);
        }
      )}}>Cargar empleados</Button>
      <Button variant="contained" color="primary" onClick={()=>{
        //Cargar los empleados con sus horarios
        fetch('/reportes')
        .then(response => response.json())
        .then(data => {
          setEmpleadosHorarios(data);
        }).catch(error => {
          console.log(error);
        }
      )}
      }>Cargar empleados con horarios</Button>
      <div>
        <h1>Listado de empleados</h1>
        {empleados.map(empleado => (
          <div key={empleado.id}>
            <p>{empleado.nombre}</p>
            <p>{empleado.categoria}</p>
          </div>
        ))}
      </div>
      <div>
        <h1>Listado de empleados con sus horarios</h1>
        {empleadosHorarios.map(empleadoHorario => (
          <div key={empleadoHorario.id}>
            <p>{empleadoHorario.empleado.nombre}</p>
            <p>{empleadoHorario.empleado.categoria}</p>
            <p>{empleadoHorario.horarios.map(horario => (
              <div key={horario.id}>
                <p>{horario.fecha}</p>
                <p>{horario.hora_ingreso}</p>
                <p>{horario.hora_salida}</p>
                <p>{horario.horas_trabajadas}</p>
              </div>
            ))}</p>
          </div>
        ))}
      </div>
    </div>
  );
}