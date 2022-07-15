/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Empresa;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Notebook
 */
public class EmpresaServicio implements IEmpresaServicio{
    
    private static final List<Empresa> listaEmpresas = new ArrayList<>();

    @Override
    public Empresa crearEmpresa(Empresa empresa) {
        
        if (codeExists(empresa.getCodigo())) {
            throw new RuntimeException("Codigo de la empresa ya existe!");
        }
        listaEmpresas.add(empresa);
        return empresa;
    }

    @Override
    public List<Empresa> listarEmpresas() {
        
        if (listaEmpresas.isEmpty()) {
            throw new RuntimeException("Lista de empresas vacia!");
        }
        
        return listaEmpresas;
    }

    @Override
    public Empresa getEmpresaByCode(int codigo) {
        for (var emp: listaEmpresas){
            if (emp.getCodigo() == codigo){
                return emp;
            }
        }
        return null;
    }

    @Override
    public void actualizarEmpresa(int codigo, Empresa empresaNueva) {
        int posicion  = getPositionEmpresa(getEmpresaByCode(codigo));
        
        if (empresaNueva.getNombre().equals("")) {
           throw new NullPointerException("Empresa debe tener un nombre");
        }
        
        if (empresaNueva.getNombreFundador().equals("")) {
           throw new NullPointerException("Empresa debe tener un fundador");
        }
        
        listaEmpresas.get(posicion).setNombre(empresaNueva.getNombre());
        listaEmpresas.get(posicion).setNombreFundador(empresaNueva.getNombreFundador());
        listaEmpresas.get(posicion).setPais(empresaNueva.getPais());
        listaEmpresas.get(posicion).setDireccion(empresaNueva.getDireccion());
        listaEmpresas.get(posicion).setFechaFundacion(empresaNueva.getFechaFundacion());
        
    }

    @Override
    public Empresa eliminarEmpresa(int codigo) {
        var posicion = getPositionEmpresa(getEmpresaByCode(codigo));
        return listaEmpresas.remove(posicion);
    }

    @Override
    public int getPositionEmpresa(Empresa empresa) {
         for (int i = 0; i < listaEmpresas.size(); i++) {
            if (empresa.getCodigo() == listaEmpresas.get(i).getCodigo()) {
                return i;
            }
        }
        return -1;
    }
    
     private boolean codeExists(int code){
        
        for (var dep: listaEmpresas) {
            if (dep.getCodigo() == code) {
                return true;
            }
        }
        return false;
    }
    
}
