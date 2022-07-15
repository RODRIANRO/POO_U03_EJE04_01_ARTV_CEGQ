/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Empresa;
import Servicio.DepartamentoServicio;
import Servicio.EmpleadoServicio;
import Servicio.EmpresaServicio;
import java.util.List;



/**
 *
 * @author Notebook
 */
public class DepartamentoControlador {
    
    private final DepartamentoServicio departamentoService = new DepartamentoServicio();
    public final EmpresaServicio empresaService = new EmpresaServicio();
    public final EmpleadoServicio empleadoService = new EmpleadoServicio();
            
    public Departamento crearDepartamento(int codigo, String nombre, Empresa empresa, String ubicacion) throws RuntimeException{
        
        if (empresa == null) {
            throw new RuntimeException("Empresa no encontrada");
        }
        
        if (nombre.equals("")) {
            throw new NullPointerException("Departamento debe tener un nombre");
        }
        
        if (ubicacion.equals("")) {
            throw new NullPointerException("Departamento debe tener una ubicacion");
        }
        
        return departamentoService.crearDepartamento(new Departamento(codigo, nombre, empresa, ubicacion));
    }
    
    public List<Departamento> listarDepartamentos(){
        return departamentoService.listarDepartamentos();
    }
    
    public Departamento getDepartamentoByCode(int code){
        return departamentoService.getDepartamentoByCode(code);
    }
    
    public void asignarGerenteDepartamento(int codigo, Empleado empleado){
        departamentoService.asignarGerente(codigo, empleado);
        
    }
    
    public void actualizarDepartamento(int codigo, Departamento departamentoNew){
        departamentoService.actualizarDepartamento(codigo, departamentoNew);
    }
    
    
    public Departamento eliminarDepartamento(int codigo){
        return departamentoService.eliminarDepartamento(codigo);
    }
    
    
   
     // Metodos validacion KeyEvent
    
    // valida que solo se ingresen numeros en el campo "codigo"
    public boolean validarSoloNumeros(char codigo){
        boolean flag = false;
        if(Character.isDigit(codigo)){
            flag = true;
        }
        return flag;
    }
    
    // valida que solo se ingrese texto en el campo ------
    public boolean validarSoloTexto(char texto){
        boolean flag = false;
        if(Character.isLetter(texto) || Character.isSpaceChar(texto) || Character.isUpperCase(texto)){
            flag = true;
        }
        return flag;
                
    }
}
