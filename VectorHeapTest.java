import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author José Rodrigo Barrera García Carnet: 20807
 * Universidad del Valle 
 * Pruebas JUnit
 *
 */


class VectorHeapTest {
	/**
     * Test of add method, of class VectorHeap.
     */
	 @Test
	    public void testAdd() {
	        System.out.println("Añadido");
	        VectorHeap<Paciente> instance = new VectorHeap<>();
	        Paciente paciente = new Paciente("Rodrigo Prueba","alergia",'F');//Object value = null;
	        //VectorHeap instance = new VectorHeap();
	        instance.add(paciente);
	        // TODO review the generated test code and remove the default call to fail.
	        //fail("The test case is a prototype.");
	    }
	 
	 /**
	     * Test of remove method, of class VectorHeap.
	     */
	 @Test
	    public void testRemove() {
	        System.out.println("Removido");
	        VectorHeap<Paciente> instance = new VectorHeap<>();
	        Paciente paciente = new Paciente("Rodrigo Prueba","alergia",'F');//Object value = null;
	        instance.add(paciente);
	        instance.remove();
	    }
}
