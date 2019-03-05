public class FIFOCache extends Cache {
        
    public FIFOCache(int size) {
        super(size);
    }

    public boolean add(int dataToAdd) {
        if(size == capacity) {//the cache is full and we have to evict
            if(!find(dataToAdd)) {//we have not found the value in the cache
                //evict the value at the current index
                values[index] = dataToAdd;

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
            }  else {
                return true;
            }
        }
    }
}