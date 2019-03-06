import java.util.HashMap;
/** An implementation of the Least Recently Used cache replacement policy.
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class LRUCache extends Cache {
    /** 
     * For this cache, we are going to use the clock method. 
     * I did this in systems last semester, and it basically allows
     * you to keep track of what is being referenced and what is not
     * using a separate array to hold the "recently referenced" tag.
     */
    
     //to hold the referenced values, we are going to use a hashmap 
    private HashMap<Integer, Boolean> referenceMap;

    /** Constructor for a LRU Cache
     * @param cacheSize The amount of values the cache can store.
    */ 
    public LRUCache(int cacheSize) {
        super(cacheSize);
        referenceMap = new HashMap<Integer, Boolean>();
    }

    /** Add a value to the cache.
     * @param dataToAdd The data that will be added to the cache.
     * @return True if we had a cache hit, false if we did not have a cache hit.
     */
    public boolean add(int dataToAdd) {
        if(size == capacity) {//the cache is full and we have to evict
            if(!find(dataToAdd)) {//we have not found the value in the cache
                
                /**
                 * If we have a full cache and we need to evict, then we look
                 * through the cache, searching for the first value that has it's 
                 * referenced flag set to false. If the value that we are checking
                 * has it's flag set to true, then we set it to false and move to the next
                 * value.
                 */
                boolean done = false;
                while(!done) {
                    //check the value that we are on
                    if(referenceMap.get(values[index]) == false) {//this is the value that we need to evict
                        done = true;

                        values[index] = dataToAdd;

                        //also set this values flag in the referenced map to true, so
                        //it is not instantly evicted next time
                        referenceMap.put(dataToAdd, true);

                        //increment the index and then we are done
                        incrementIndex();
                    } else {//the value that we are on has been referenced recently
                        //set the value at the current index to false
                        referenceMap.put(values[index], false);

                        //increment the counter so we can move on to the next value
                        incrementIndex();
                    }
                }

                return false;
            } else {//we have found the data
                //we need to update the referenced flag to reflect that we have had a cache hit
                referenceMap.put(dataToAdd, true);

                return true;
            }
        } else {//just add the value to the cache
            if(!find(dataToAdd)) {
                //the value is added to the cache
                values[index] = dataToAdd;
                size++;

                //hash the value so we know that we have seen it before
                referenceMap.put(dataToAdd, true);
            
                //now we increment the index to the next spot to add a value
                incrementIndex();

                return false;
            } else {
                return true;
            }
        }
    }
    
    public void printCache() {
        System.out.println("==================Cache State==================");
        for(int i: values) {
            System.out.print(i + " " + referenceMap.get(i) + '\n');
        }
        System.out.println();
    }
}