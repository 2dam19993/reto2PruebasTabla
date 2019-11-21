/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtabla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Usuario
 */
public class EsperBean {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apodo;
    private final SimpleStringProperty poder;
    private final SimpleIntegerProperty edad;
    
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setApodo(String apodo) {
       this.nombre.set(apodo);
    }

    public void setPoder(String poder) {
       this.nombre.set(poder);
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }
    public String getNombre() {
        return nombre.get();
    }

    public String getApodo() {
        return apodo.get();
    }

    public String getPoder() {
        return poder.get();
    }

    public int getEdad() {
        return edad.get();
    }
   
    
    public EsperBean(String nombre,String apodo,String poder,int edad){
        this.nombre=new SimpleStringProperty(nombre);
        this.apodo=new SimpleStringProperty(apodo);
        this.poder=new SimpleStringProperty(poder);
        this.edad=new SimpleIntegerProperty(edad);
    }
    
    
    
}
