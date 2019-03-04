public class Cache {
    protected int[] values;
    protected int size;
    protected int capacity;
    protected int index;


    public Cache(int size) {
        this.size = 0;
        capacity = size;
        values = new int[size];
        index = 0;
    }

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

    public void add(int dataToAdd) {}

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