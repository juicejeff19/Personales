/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayserial;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author juice_pjuorme
 */
public class Persona {
    String nombre, edad;
    ArrayList<Persona> list;

    public Persona() {
        list = new ArrayList<>();
    }

    public Persona(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public ArrayList<Persona> getList() {
        return list;
    }

    public void setList(ArrayList<Persona> list) {
        this.list = list;
    }
    
    @Override
   public String toString() {
        return ("\n"+"************"+"\n"+"Nombre: "+this.getNombre()+ "\n" +
                    "Edad: "+ this.getEdad()+"\n"+"************"+"\n");
   }
   
   public void recuperar(String nombre,String edad){
       setNombre(nombre);
       setEdad(edad);
       agregar();
   }
   
   public void agregar(){
       Persona individuo = new Persona();
       individuo.setNombre(nombre);
       individuo.setEdad(edad);
       list.add(individuo);
       JOptionPane.showMessageDialog(null, "Registro Exitoso");
       
   }
   public void mostrar(){
       if(list.isEmpty()){
           System.out.println("La lista esta vacia");
       }else{
           System.out.println(list);
       }
   }
   
   public void menucontrol(){
       Scanner entrada = new Scanner(System.in);
       int opcion;
       System.out.println("Seleccione la operación a realizar:"
               + "\n"
               + "1.Eliminar un registro");
       opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la opcion de la operacion a realizar"+ "\n"
               + "1.Eliminar un registro"));
       
       switch (opcion) {
           case 1:
               try{
               String nombreEliminar;
               System.out.println("Ingrese el nombre de la persona a eliminar del registro");
               nombreEliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre de la persona a eliminar");
               Persona personaeliminar = buscarPersona(nombreEliminar);
               eliminarPersona(personaeliminar);
               JOptionPane.showMessageDialog(null, "El registro fue eliminado");
               }catch(Exception e){
                   System.out.println("Error: "+e);
               }
               break;
           default:
               throw new AssertionError();
       }
   }
   
   public Persona buscarPersona(String id){
        //necesito un objeto de persona
        Persona encontrada = new Persona();
        //recorrer todos los registros hasta que el id = al que buscando
        for(Persona p : list){
            //de persona vas a buscar hasta que en listapersona encuentras id
            if(id.equals(p.getNombre())){
                encontrada = p;
            }
        }
        return encontrada;
    }
    public void eliminarPersona(Persona eliminar){
        list.remove(eliminar);
    }
    
    
}
