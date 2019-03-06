/** Class that represents a Cache.
 * This is the parent class of all the other caches included in the simulation.
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */

public class Cache {
    protected int[] values;
    protected int size;
    protected int capacity;
    protected int index;

    /** Constructor for a Cache Object.
     * @param cacheSize The amount of cache spaces that the cache will have.
     */
    public Cache(int cacheSize) {
        size = 0;
        capacity = cacheSize;
        values = new int[cacheSize];
        index = 0;
    }

    /** Checks to see if a value is stored in the cache.
     * @param dataToFind The data that we are searching the cache for.
     * @return True if we found the value in the cache, false if we did not.
     */
    public boolean find(int dataToFind) {
        //associative caches have the hardware advantage of searching all
        //places at once, but since we do not have that luxury and because
        //I don't want to keep the cache sorted, this is a linear search
        for(int i = 0; i < capacity; i++) {
            if(values[i] == dataToFind) {
                return true;
            }
        }
        return false;
    }

    /** Prints the current contents of the Cache.
     */
    public void printCache() {
        System.out.println("==================Cache==================");
        for(int i: values) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void incrementIndex() {
        if(index == capacity - 1) {//we have reached the end of the cache
            index = 0;
        } else {
            index++;
        }
    }
}