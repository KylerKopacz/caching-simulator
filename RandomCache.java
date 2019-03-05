import java.util.Random;

public class RandomCache extends Cache {

    //random instance for evicting random elements
    Random rand;
    
    public RandomCache(int size) {
        super(size);
        rand = new Random();
    }

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