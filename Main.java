import java.util.*;

/**
 *
 * @author José Rodrigo Barrera García Carnet:20807
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 8
 * Para cada uno de los codigos se tomo como referencia el de Douglas brindado en clase 
 * Como también, para arreglar los errores presentes en dicho codigo tomé como referencia
 * la siguiente pagina: https://www.geeksforgeeks.org/max-heap-in-java/
 *https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 *Cabe a mencionar también que para el caso del txt de los pacientes, considere cambiar 
 *La gravedad o el codigo de gravedad de Carmen Sarmientos que tiene dolores de parto 
 *lo pase a un codigo A, ya que lo consideré necesario, como también, para poder 
 *probar su funcionamiento me agregue yo mismo con una enfermedad.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Se leen el archivo que contiene la lista de pacientes*/
        Vector listaEntrante = LecturaArchivo.mostrarContenido("Pacientes.txt");
        VectorHeap <Paciente> listaFinal = new VectorHeap();
        Iterator itr = listaEntrante.iterator();
        System.out.println("Pacientes ingresados");
        /*Por cada linea de texto se crea un objeto tipo Paciente y se ingresa al VectorHeap Final*/
        while (itr.hasNext()){
            String descripcion = (String) itr.next();
            String nombre = descripcion.substring(0, descripcion.indexOf(","));
            String diagnostico = descripcion.substring(descripcion.indexOf(",")+2,descripcion.lastIndexOf(","));
            String codigo = descripcion.substring(descripcion.lastIndexOf(",")+2);
            System.out.println(nombre+", "+diagnostico+", "+codigo);
            Paciente dummy = new Paciente(nombre, diagnostico,codigo.charAt(0));
            listaFinal.add(dummy);
        }
        /*Se remueven del vectorHeap para desplegarlos en pantalla*/
        System.out.println("\n --------------------------------- ATENCION: Lista ordenada de pacientes: -------------------------");
        while(listaFinal.isEmpty()==false){
            System.out.println(listaFinal.remove());
        }
        
    }
    
}
