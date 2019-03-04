public class CachesTester {
    public static void main(String[] args) {
        Uniform dist = new Uniform(20);

        //The FIFO Cache
        System.out.println("###############THE FIFO CACHE###############");
        FIFOCache fifoc = new FIFOCache(3);
        for(int i = 0; i < 10; i++) {
            int numToAdd = dist.next();
            System.out.println("\nAdding " + numToAdd + "...");
            fifoc.add(numToAdd);
            fifoc.printCache();
        }
        System.out.println();

        //The Random Cache
        System.out.println("###############THE RANDOM CACHE###############");
        RandomCache rc = new RandomCache(5);
        for(int i = 0; i < 10; i++) {
            int numToAdd = dist.next();
            System.out.println("\nAdding " + numToAdd + "...");
            rc.add(numToAdd);
            rc.printCache();
        }
        System.out.println();

        //The LRU Cache
        System.out.println("###############THE LRU CACHE###############");
        LRUCache lruc = new LRUCache(5);
        for(int i = 0; i < 20; i++) {
            int numToAdd = dist.next();
            lruc.add(numToAdd);
            System.out.println("\nAdding " + numToAdd + "...");
            lruc.printCache(); 
        }
        System.out.println();

        //The LFU Cache
        System.out.println("###############THE LFU CACHE###############");
        LFUCache lfuc = new LFUCache(5, 20);
        for(int i = 0; i < 20; i++) {
            int numToAdd = dist.next();
            lfuc.add(numToAdd);
            System.out.println("\nAdding " + numToAdd + "...");
            lfuc.printCache(); 
        }
        System.out.println();

    }
}