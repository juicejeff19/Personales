/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayserial;
//importo librerias conforme hago el codigo xd
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author juice_pjuorme
 */
public class Persona {
    //la clase persona tieneestos atributos
    String nombre, edad;
    ArrayList<Persona> list;
//constructor de clase persona el cual usare para inicializar cosas
    public Persona() {
        list = new ArrayList<>();
    }
//xd
    public Persona(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
//getters y setters
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
    //fin de getters y setters
    
    //sobreescribo el metodo toString para que asi mis arraylist sean legibles dentro de la clase persona
    @Override
   public String toString() {
        return ("\n"+"************"+"\n"+"Nombre: "+this.getNombre()+ "\n" +
                    "Edad: "+ this.getEdad()+"\n"+"************"+"\n");
   }
   //se ocupa este metodo para recuperar los datos dentro de la clase Interfaz,
   //la cual le dara el texto dentro de los TextField como argumentos
   public void recuperar(String nombre,String edad){
       setNombre(nombre);
       setEdad(edad);
       agregar();
   }
   //se creara un individuo cada vez que este metodo es llamado, estableciendose asi sus aributos gracias a los setters de la clase
   //se añadira el individuo a una lista de individuos
   public void agregar(){
       Persona individuo = new Persona();
       individuo.setNombre(nombre);
       individuo.setEdad(edad);
       list.add(individuo);
       JOptionPane.showMessageDialog(null, "Registro Exitoso"); 
   }
   //metodo para mostrar la lista en la consola
   public void mostrar(){
       if(list.isEmpty()){
           System.out.println("La lista esta vacia");
       }else{
           System.out.println(list);
       }
   }
   //menu que servira para controlar la lista
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
   //metodo que busca a una persona dentro de la lista con base en uno de sus atributos
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
   //metodo que elimina elementos de la lista (f)
    public void eliminarPersona(Persona eliminar){
        list.remove(eliminar);
    }
    
    
}
