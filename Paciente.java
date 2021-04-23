/**
 * @author José Rodrigo Barrera García Carnet:20807
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 8
 *
 */
public class Paciente implements Comparable<Paciente>{

   /*Atributos*/
    private String nombre;
    private String diagnostico; 
    private char codigoE;
    
    /*Constructor*/
    public Paciente(String nombre, String diagnostico, char codigoE) {
        this.nombre = nombre;
        this.diagnostico = diagnostico;
        this.codigoE = codigoE;
    }
    
    public Paciente(){
        nombre = "Juan";
        diagnostico = "nada serio";
        codigoE = 1001;
    }
        
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    public String getDiagnostico() {
        return diagnostico;
    
    }
    public void setDiagnostico(String diagnostico) {
        this.nombre = diagnostico;
    }
    
    public char getCodigoE() {
        return codigoE;
    
    }
    public void setCodigoE(char codigoE) {
        this.codigoE = codigoE;
    }

  
    public String toString() {
        return "Nombre Paciente:" + nombre + ", Diagnostico:" + diagnostico + ", Codigo de emergencia:" + codigoE;
    }

    @Override
    
    public int compareTo(final Paciente o) {
        int resultado = 0;
   
        if (this.codigoE< o.codigoE){
        resultado = -1;
        }else if (this.codigoE == o.codigoE){
        resultado = 0;
        }else{
        resultado =1;
        }
    return resultado; 
    }
   
    

    
}

