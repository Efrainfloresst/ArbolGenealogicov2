/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class NodoMV implements Comparable<String>{
    
    public String data1; // nombre del hombre
    public String data2; // nombre de la mujer
    public ArrayList<NodoMV> hijos;

    public NodoMV() {
        this.hijos= new ArrayList<>();
        this.data1= new String(); // this.data1="";
        this.data2= new String();
        
        
    }

    public NodoMV(String hombre) {
        this.data1 = hombre;
        this.data2=new String();
        this.hijos=new ArrayList<>();
    }

    public NodoMV(String data1, String data2) {
        this.data1 = data1;
        this.data2 = data2;
        hijos=new ArrayList<>();
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public ArrayList<NodoMV> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodoMV> hijos) {
        this.hijos = hijos;
    }
    
    public void addHijo(NodoMV hijo){
        this.hijos.add(hijo);
    }
    
    public void setHijo(int pos,NodoMV hijo){
        this.hijos.set(pos, hijo);
    }
    
    public void delHijo(NodoMV hijo){
        this.hijos.remove(hijo);
    }
    
    public void delHijo(int pos){
        this.hijos.remove(pos);
    }
 
    public boolean datasLlenas(){
        return this.getData1().length()>0 && this.getData2().length()>0;
        
    }
    
    public boolean sinHijos(){ // nodo hoja en otras palabras
        return this.hijos.size()==0;
    }
    
    public boolean sinData2(){ // falta el data2 (falta la esposa)
        return this.getData2().length()==0; // this.getData2()=="";
        
    }

   @Override
    public int compareTo(String otro) {
        // DEVUELVE -1 => SI EL STRING DATA1 < Otro
        // DEVUELVE 0 => SI EL STRING DATA1 == Otro
        // DEVUELVE -1=> SI EL STRING DATA2 > Otro
        //int i="A".compareTo("B");
        return this.getData1().compareTo(otro);
        
    }
    
   
}
