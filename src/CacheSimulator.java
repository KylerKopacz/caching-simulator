import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.File;

/** Runs a simulation of the 4 included cache replacement policies with the 3 provided distribution types.
 * Outputs the number of cache hits to a generated csv file.
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class CacheSimulator {
    public static void main(String[] args) throws IOException {
        int cacheSize = 10;
        int numberOfRequests = 1000000;

        //caches 
        LRUCache lruc;
        LFUCache lfuc;
        RandomCache rc;
        FIFOCache fifoc;

        //file writer to write the outputs
        File file = new File("results.csv");
        FileWriter wr = new FileWriter(file);
        wr.write("policy, hits, cacheSize, distribution\n");
        


        //distributions
        Uniform uniform = new Uniform(1000);
        Zipf zipf = new Zipf(1000);
        RequestGenerator rg = new RequestGenerator();

        //run simulations for every cache size
        while(cacheSize <= 200) {
            //run the uniform test
            //initialize the caches
            lruc = new LRUCache(cacheSize);
            lfuc = new LFUCache(cacheSize, 1000);
            rc = new RandomCache(cacheSize);
            fifoc = new FIFOCache(cacheSize);

            //hit variables
            int lruhits = 0;
            int lfuhits = 0;
            int rchits = 0;
            int fifohits = 0;
            int total = 0;

            for(int i = 0; i < numberOfRequests; i++) {
                int request = uniform.next();
                //System.out.println("Adding " + request);
                if(i >= 10000) {
                    if(lruc.add(request)) {
                        lruhits++;
                    }
                    if(lfuc.add(request)) {
                        lfuhits++;
                    }
                    if(rc.add(request)) {
                        rchits++;
                    }
                    if(fifoc.add(request)) {
                        fifohits++;
                    }
                    total++;
                } else {
                    lruc.add(request);
                    lfuc.add(request);
                    rc.add(request);
                    fifoc.add(request);
                }
            }
            //print the results
            System.out.println("=====Cache of " + cacheSize + " (Uniform)=====");
            System.out.println("FIFO: " + fifohits + "/" + total);
            System.out.println("Random: " + rchits + "/" + total);
            System.out.println("LFU: " + lfuhits + "/" + total);
            System.out.println("LRU: " + lruhits + "/" + total);
            System.out.println();

            //write to the file 
            try {
                wr.write("fifo," + fifohits + ", " + cacheSize + ", uniform" + '\n');
                wr.write("random," + rchits  + ", " + cacheSize + ", uniform" + '\n');
                wr.write("lfu," + lfuhits  + ", " + cacheSize + ", uniform" + '\n');
                wr.write("lru," + lruhits  + ", " + cacheSize + ", uniform" + '\n');
            } catch (IOException e) {}
            




            //run the zipf test
            //initialize the caches
            lruc = new LRUCache(cacheSize);
            lfuc = new LFUCache(cacheSize, 1000);
            rc = new RandomCache(cacheSize);
            fifoc = new FIFOCache(cacheSize);

            //hit variables
            lruhits = 0;
            lfuhits = 0;
            rchits = 0;
            fifohits = 0;
            total = 0;

            for(int i = 0; i < numberOfRequests; i++) {
                int request = zipf.next();
                //System.out.println("Adding " + request);
                if(i >= 10000) {
                    if(lruc.add(request)) {
                        lruhits++;
                    }
                    if(lfuc.add(request)) {
                        lfuhits++;
                    }
                    if(rc.add(request)) {
                        rchits++;
                    }
                    if(fifoc.add(request)) {
                        fifohits++;
                    }
                    total++;
                } else {
                    lruc.add(request);
                    lfuc.add(request);
                    rc.add(request);
                    fifoc.add(request);
                }
            }
            //print the results
            System.out.println("=====Cache of " + cacheSize + " (Zipf)=====");
            System.out.println("FIFO: " + fifohits + "/" + total);
            System.out.println("Random: " + rchits + "/" + total);
            System.out.println("LFU: " + lfuhits + "/" + total);
            System.out.println("LRU: " + lruhits + "/" + total);
            System.out.println();

            //write to file
            //write to the file
            try {
                wr.write("fifo," + fifohits + ", " + cacheSize + ", zipf" + '\n');
                wr.write("random," + rchits  + ", " + cacheSize + ", zipf" + '\n');
                wr.write("lfu," + lfuhits  + ", " + cacheSize + ", zipf" + '\n');
                wr.write("lru," + lruhits  + ", " + cacheSize + ", zipf" + '\n');
            } catch(IOException e) {}
            


            //Run the RandomGenerator Test
            //initialize the caches
            lruc = new LRUCache(cacheSize);
            lfuc = new LFUCache(cacheSize, 1000);
            rc = new RandomCache(cacheSize);
            fifoc = new FIFOCache(cacheSize);

            //hit variables
            lruhits = 0;
            lfuhits = 0;
            rchits = 0;
            fifohits = 0;
            total = 0;

            for(int i = 0; i < numberOfRequests; i++) {
                int request = rg.generateRequest();
                //System.out.println("Adding " + request);
                if(i >= 10000) {
                    if(lruc.add(request)) {
                        lruhits++;
                    }
                    if(lfuc.add(request)) {
                        lfuhits++;
                    }
                    if(rc.add(request)) {
                        rchits++;
                    }
                    if(fifoc.add(request)) {
                        fifohits++;
                    }
                    total++;
                } else {
                    lruc.add(request);
                    lfuc.add(request);
                    rc.add(request);
                    fifoc.add(request);
                }
            }
            //print the results
            System.out.println("=====Cache of " + cacheSize + " (RandomGenerator)=====");
            System.out.println("FIFO: " + fifohits + "/" + total);
            System.out.println("Random: " + rchits + "/" + total);
            System.out.println("LFU: " + lfuhits + "/" + total);
            System.out.println("LRU: " + lruhits + "/" + total);
            System.out.println();

            //write to file
            try {
                wr.write("fifo," + fifohits + ", " + cacheSize + ", randomgenerator" + '\n');
                wr.write("random," + rchits  + ", " + cacheSize + ", randomgenerator" + '\n');
                wr.write("lfu," + lfuhits  + ", " + cacheSize + ", randomgenerator" + '\n');
                wr.write("lru," + lruhits  + ", " + cacheSize + ", randomgenerator" + '\n');
            } catch (IOException e) {}




            //increment the size of the cache
            cacheSize += 10;
        }
        try {
            wr.close();
        } catch (IOException e) {}
        System.out.println("The results of this simulation were written to the results.csv file!");
    }
}