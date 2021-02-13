/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayserial;
//importo librerias conforme hago el codigo xd
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author juice_pjuorme
 */
public class Persona implements Serializable{
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
       System.out.println("CRUD");
       opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la opción correspondiente a la operación a realizar"+ "\n"
               + "1. Eliminar un registro"
               + "\n"
               + "2. Actualizar un registro"
               + "\n"
               + "3. Guardar registros"
               + "\n"
               + "4. Recuperar Registros"));
       
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
           case 2:
               String nombreActualizar, nuevoNombre, nuevaEdad;
                nombreActualizar=JOptionPane.showInputDialog(null, "Ingrese el nombre de la persona a actualizar");
                Persona personaBuscar = buscarPersona(nombreActualizar);
                
                //visualizamos la informacion de esa persona
                
                System.out.println("La informacion de la persona es:\n"
                        + "ID: " + "\n"
                        + "Nombre: " + personaBuscar.getNombre()+"\n"
                        + "Edad: "+ personaBuscar.getEdad());
                
                //ahora vamos a cambiar los datos
                System.out.println("Ingresa el nuevo nombre: ");
                nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre");
                System.out.println("Ingresa la nueva edad: ");
                nuevaEdad = JOptionPane.showInputDialog(null, "Ingrese la nueva Edad");
                
                //con set esos nuevos parametros
                personaBuscar.setNombre(nuevoNombre);
                personaBuscar.setEdad(nuevaEdad);
                
                //actualizo mi lista
                actualizarPersona(personaBuscar);
                break;
           default:
               throw new AssertionError();
               
           case 3:
               serializar();
           case 4:
               leer();
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
    public void actualizarPersona(Persona actualizada){
        Persona actualizar = buscarPersona(actualizada.getNombre());
        //ya lo busco y lo encontro
        
        //primero debo de removerlo
        list.remove(actualizar);
        
        //lo volvemos a meter
        list.add(actualizada);
    }
    
    public void serializar(){
         try
        {
            FileOutputStream fos = new FileOutputStream("datosPersonas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
    
    public void leer(){
        try
        {
            FileInputStream fis = new FileInputStream("datosPersonas");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            list = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
         
        //Verify list data
        for (Persona employee : list) {
            System.out.println(employee);
        }
    }
}
    

