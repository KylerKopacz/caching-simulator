import java.util.Random;
/** Implementation of Random cache replacement policy.
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class RandomCache extends Cache {

    //random instance for evicting random elements
    private Random rand;
    
    /** Constructor for a Random Cache
     * @param cacheSize The amount of values the cache can store.
    */ 
    public RandomCache(int cacheSize) {
        super(cacheSize);
        rand = new Random();
    }

    /** Add a value to the cache.
     * @param dataToAdd The data that will be added to the cache.
     * @return True if we had a cache hit, false if we did not have a cache hit.
     */
    public boolean add(int dataToAdd) {
        if(size == capacity) {//the cache is full and we have to evict
            if(!find(dataToAdd)) {//we have not found the value in the cache
                values[rand.nextInt(size)] = dataToAdd;

                //now increment the index
                incrementIndex();

                return false;
            } else {
                return true;
            }
        } else {//just add the value to the cache
            if(!find(dataToAdd)) {
                values[index] = dataToAdd;
                size++;
            
                //now we increment the index to the next spot to add a value
                incrementIndex();

                return false;
            } else {
                return true;
            }
        }
    }
}