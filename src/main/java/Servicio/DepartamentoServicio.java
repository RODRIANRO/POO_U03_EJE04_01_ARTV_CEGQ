/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Departamento;
import Modelo.Empleado;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Notebook
 */
public class DepartamentoServicio implements IDepartamentoServicio{
    
    private static final List<Departamento> listaDepartamentos = new ArrayList<>();

    @Override
    public Departamento crearDepartamento(Departamento departamento) {
        if (codeExists(departamento.getCodigo())) {
           throw new RuntimeException("El codigo de departamento ("+departamento.getCodigo()+") ya existe");
        }
        listaDepartamentos.add(departamento);
        return departamento; 
        
    }

    @Override
    public List<Departamento> listarDepartamentos() {
       
        if (listaDepartamentos.isEmpty()) {
            throw new RuntimeException("Lista de departamentos vacia!");
        }
        
        return listaDepartamentos;
    }

    @Override
    public Departamento getDepartamentoByCode(int codigo) {
        for(Departamento dep : listaDepartamentos){
            if(dep.getCodigo() == codigo){
                return dep;
            }
        }
        return null;
    }
    
    public void asignarGerente(int codigo, Empleado empleado){
        getDepartamentoByCode(codigo).asignarGerente(empleado);
        
    }

    @Override
    public void actualizarDepartamento(int codigo, Departamento departamentoNew) {
       int posicion = getPositionDepartamento(getDepartamentoByCode(codigo));
       
        if (departamentoNew.getNombre().equals("")) {
            throw new NullPointerException("Debe ingresar el nombre de departamento");
        }
        
        if (departamentoNew.getUbicacion().equals("")) {
            throw new NullPointerException("Debe ingresar la ubicacion de departamento");
        }
       
       listaDepartamentos.get(posicion).setNombre(departamentoNew.getNombre());
       listaDepartamentos.get(posicion).asignarGerente(departamentoNew.getGerente());
       listaDepartamentos.get(posicion).setEmpresa(departamentoNew.getEmpresa());
       listaDepartamentos.get(posicion).setUbicacion(departamentoNew.getUbicacion());
    }

    @Override
    public Departamento eliminarDepartamento(int codigo) {
       var posicion = getPositionDepartamento(getDepartamentoByCode(codigo));
       return listaDepartamentos.remove(posicion);
    }

    @Override
    public int getPositionDepartamento(Departamento departamento) {
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            if (departamento.getCodigo() == listaDepartamentos.get(i).getCodigo()) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean codeExists(int code){
        
        for (var dep: listaDepartamentos) {
            if (dep.getCodigo() == code) {
                return true;
            }
        }
        return false;
    }
    
}
