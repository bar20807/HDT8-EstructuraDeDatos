import java.util.PriorityQueue;
import java.util.Vector;
/**
 * @author José Rodrigo Barrera García Carnet: 20807
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 8
 *Este codigo fue tomado de los ejemplos brindados por Douglas, como también 
 * se tomo como referencia la siguiente pagina para arreglar algunos errores 
 * presentes en el codigo: https://www.geeksforgeeks.org/max-heap-in-java/
 *https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 */
public class VectorHeap<E extends Comparable<E>> extends PriorityQueue<E>
{
    /**
     * The data, kept in heap order.
     */
    protected Vector<E> data;  // the data, kept in heap order

    /**
     * Construct a new priority queue
     *
     * constructs a new priority queue
     */
    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     * Construct a new priority queue from an unordered vector
     *
     * constructs a new priority queue from an unordered vector
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        {   // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Returns parent index
     * @param i a node index
     * @return parent of node at i
     */
    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * Returns left child index.
     * @param i a node index
     * @return left child of node at i

     */
    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * Returns right child index.
     * @param i a node index
     * @return right child of node at i
     */
    protected static int right(int i)
    {
        return 2*(i+1);
    }

    /**
     * Fetch lowest valued (highest priority) item from queue.
     *
     * 
     * @return The smallest value from queue.
     */
    public E getFirst()
    {
        return data.get(0);
    }

    /**
     * Returns the minimum value from the queue.
     *
     * 
     * @return The minimum value in the queue.
     */
    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Add a value to the priority queue.
     *
     * 
     * @param value The value to be added.
     */
    public boolean add(E value)
    {
        data.add(value);
        percolateUp(data.size()-1);
        return true;
    }

    /**
     * Determine if the queue is empty.
     *
     * 
     * @return True if the queue is empty.
     */
    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     * Moves node upward to appropriate position within heap.
     * @param leaf Index of the node in the heap.
     */
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
          (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Moves node downward, into appropriate position within subheap.
     * @param root Index of the root of the subheap.
     */
    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                  ((data.get(childpos+1)).compareTo
                   (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                    (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }       
        }
    }

    /**
     * Determine the size of the queue.
     *
     * 
     * @return The number of elements within the queue.
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Remove all the elements from the queue.
     *
     */
    public void clear()
    {
        data.clear();
    } 
    
    /**
     * Construct a string representation of the heap.
     *
     * 
     * @return The string representing the heap.
     */
    public String toString()
    {
        return "<VectorHeap: "+data+">";
    }
}
