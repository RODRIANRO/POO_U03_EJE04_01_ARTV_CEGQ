/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Departamento;
import Modelo.Empleado;
import Servicio.DepartamentoServicio;
import Servicio.EmpleadoServicio;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author Notebook
 */
public class EmpleadoControlador {
    private final EmpleadoServicio empleadoService = new EmpleadoServicio();
    public final DepartamentoServicio departamentoService = new DepartamentoServicio();
    
    public Empleado crearEmpleado(String cedula, String nombre, int anioNacimiento, int mesNacimiento, int diaNacimiento, 
            String nacionalidad, String direccion, String cargo, float salario, Departamento departamento){
        
        var fechaNacimiento = LocalDate.of(anioNacimiento, mesNacimiento, diaNacimiento);
        // fecha de entrada = fecha del sistema
        var fechaEntrada = LocalDate.now();
        
        var nuevoEmpleado =  new Empleado(cedula,nombre,fechaNacimiento,nacionalidad,direccion,cargo,salario,fechaEntrada,departamento);
        return empleadoService.crearEmpleado(nuevoEmpleado);
                
    }
    
    public List<Empleado> listarEmpleados(){
        return empleadoService.listarEmpleados();
    }
    
    public Empleado getEmpleadoByCedula(String cedula){
        return empleadoService.getEmpleadoByCedula(cedula);
    }
    
     public void asignarDepartamento(String cedula, Departamento departamento){
        empleadoService.asignarDepartamento(cedula, departamento);
    }
     
    public void actualizarEmpleado(String cedula, Empleado empleadoNew){
        empleadoService.actualizarEmpleado(cedula, empleadoNew);
    } 
     
    public Empleado eliminarEmpleado(String cedula){
        return empleadoService.eliminarEmpleado(cedula);
    }
     
    
    
    
    
   
      // Metodos validacion KeyEvent
    
    // valida que solo se ingresen numeros en el campo "cedula"
    public boolean validarSoloNumeros(char codigo){
        boolean flag = false;
        if(Character.isDigit(codigo)){
            flag = true;
        }
        return flag;
    }
    
    // valida que solo se ingrese texto en el campo "nombre"
    public boolean validarSoloTexto(char texto){
        boolean flag = false;
        if(Character.isLetter(texto) || Character.isSpaceChar(texto) || Character.isUpperCase(texto)){
            flag = true;
        }
        return flag;
                
    }
}
