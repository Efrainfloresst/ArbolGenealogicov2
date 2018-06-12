/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author USUARIO
 */
public class ArbolGenealogico {
    
    private NodoMV raiz;
    
    public ArbolGenealogico(String hombre,String mujer){
        raiz=new NodoMV(hombre, mujer);
    }
    
    private boolean vacio(){
        return raiz==null;
    }
    
    /*public boolean addHombreOrigen(String nameHombre){
        if (vacio()){
            raiz=new NodoMV(nameHombre);
            return true;
        } else {
            return false;
        }
    }*/
    
    public boolean addEsposa(String nombreEsposo,String nombreMujer){
        if (!vacio()){           
            NodoMV nodoEsposo=getNodo(nombreEsposo,1);
            if (nodoEsposo!=null && nodoEsposo.sinData2()){
                nodoEsposo.setData2(nombreMujer);
                return true;
            }            
        }
        return false;
    }
    
    public boolean addHijoPorPadre(String namePadre, String nameHijo) {
        if (!vacio()){
             // buscar en todos los nodos si existe nombreHijo en data1
            NodoMV nodoPadre=getNodo(namePadre,1);
            if (nodoPadre!=null && nodoPadre.datasLlenas()
                    && nodoPadre.getData1().compareTo(nameHijo)!=0){
                nodoPadre.addHijo(new NodoMV(nameHijo));
                return true;
            } else {
                System.out.println("hijo y padre con el mismo nombre, no se puede insertar");
            } 
            
        }
        return false;
    }

    public boolean addHijoPorMadre(String nombreMadre,String nombreHijo){
        if (!vacio()){
            // buscar en todos los nodos si existe nombreHijo en data1
            NodoMV nodoMadre=getNodo(nombreMadre,2);
            if (nodoMadre!=null && nodoMadre.datasLlenas()){
                nodoMadre.addHijo(new NodoMV(nombreHijo));
                return true;
            }
        }
        return false;
    }
    
    private NodoMV getNodo(String nombre,int tipoBusqueda) {
        return getNodo(raiz,nombre,tipoBusqueda);
    }

    private NodoMV getNodo(NodoMV nodo, String nombre,int tipo) {
        if (nodo!=null){
            if (tipo==1 && nodo.getData1().compareTo(nombre)==0){
                return nodo;
            } 
            if (tipo==2 && nodo.getData2().compareTo(nombre)==0){
                return nodo;
            } 
            for (NodoMV hijoActual : nodo.getHijos()) {
                return getNodo(hijoActual, nombre, tipo);
            }
        }
        return null;
    }
    
    public List recorridoPorNiveles(){
        List porNiveles=new LinkedList();
        if (!vacio()){
            Queue<NodoMV> colaHijos=new LinkedList<>();            
            colaHijos.offer(raiz);
            while (!colaHijos.isEmpty()){
                NodoMV nodoActual=colaHijos.poll();
                if (nodoActual.getData1().length()>0){
                    porNiveles.add(nodoActual.getData1());
                } 
                if (nodoActual.getData2().length()>0){
                    porNiveles.add(nodoActual.getData2());
                }
                for (NodoMV hijoActual : nodoActual.getHijos()) {
                    if (hijoActual!=null){
                        colaHijos.offer(hijoActual);
                    }
                }
            }
        }
        return porNiveles;                
    }

    
    
    
}
