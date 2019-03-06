/** Implementation of a Least-Frequently-Used cache replacement policy.
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class LFUCache extends Cache {

    private int[] frequencies;

    /** Constructor for a LFU Cache
     * @param cacheSize The amount of values the cache can store.
     * @param upperBound The max value that can be stored in the cache.
    */ 
    public LFUCache(int cacheSize, int upperBound) {
        super(cacheSize);
        frequencies = new int[upperBound];
    }

    /** Add a value to the cache.
     * @param dataToAdd The data that will be added to the cache.
     * @return True if we had a cache hit, false if we did not have a cache hit.
     */
    public boolean add(int dataToAdd) {
        if(size == capacity) {//the cache is full and we have to evict
            if(!find(dataToAdd)) {//we have not found the value in the cache
                
                //we need to find the index that has the lowest frequency
                int lowestFrequencyIndex = 0;
                int lowestFrequency = Integer.MAX_VALUE;
                for(int i = 0; i <  values.length; i++) {
                    if(frequencies[values[i] - 1] < lowestFrequency) {
                        lowestFrequency = frequencies[values[i] - 1];
                        lowestFrequencyIndex = i;
                    }
                }

                //now we swap the value at the lowest index with the data to add
                values[lowestFrequencyIndex] = dataToAdd;

                //also, increment the reference count of the thing that we just
                //added to the cache
                frequencies[dataToAdd - 1]++;

                //now increment the index
                incrementIndex();

                return false;
            } else {//we have found the value in the cache
                //update the referenced count
                frequencies[dataToAdd - 1]++;

                return true;
            }
        } else {//just add the value to the cache
            if(!find(dataToAdd)) {
                values[index] = dataToAdd;
                size++;

                //update the frequencies
                frequencies[dataToAdd - 1]++;
            
                //now we increment the index to the next spot to add a value
                incrementIndex();

                return false;
            } else {//we have a cache hit and the cache is not full yet
                //update the frequency
                frequencies[dataToAdd - 1]++;

                return true;
            }
        }
    }

    public void printCache() {
        System.out.println("==================Cache State==================");
        for(int i: values) {
            if(i > 0) {
                System.out.println(i + " has been referenced " + frequencies[i - 1] + " time(s)");
            }
        }
        System.out.println();
    }
}