import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @author José Rodrigo Barrera García Carnet:20807
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 8
 */
public class LecturaArchivo {
    public static Vector mostrarContenido(String archivo) {
        Vector parrafo = new Vector(20,5);
        try{
        String linea;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((linea = b.readLine())!=null) {
            parrafo.addElement(linea);
        }
        b.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return parrafo;
    }

}
