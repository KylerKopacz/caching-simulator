public class ZipfTester {
    public static void main(String[] args) {
        int size = 1000;
        int iterations = 10000000;
        int[] counts = new int[size];
        Zipf z = new Zipf(size);


        z.printMap();

        //System.out.println("=====HERE COMES SOME VALUES=====");
        double total = 0;
        for(int i = 0; i < iterations; i++) {
            int value = z.next();
            //System.out.println(value);
            counts[value - 1]++;
            total++;
        }

        System.out.println("\n=====Summary=====");
        for(int i = 0; i < counts.length; i++) {
            System.out.println((i+1) + " : " + (counts[i]/total));
        }
        
    }
}