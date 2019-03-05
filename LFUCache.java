public class LFUCache extends Cache {
    
    /**
     * For this, we can just count the number of times that a number occurs by 
     * creating another array the size of the range of numbers we are working with, 
     * and incrementing the counter of that corresponding slot every time we see it.
     */

    int[] frequencies;

    public LFUCache(int size, int upperBound) {
        super(size);
        frequencies = new int[upperBound];
    }

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