import java.util.Random;
import java.util.TreeMap;
import java.util.NavigableMap;

public class Zipf {

    private int distSize;
    private double denominator;
    private Random r;
    private NavigableMap<Integer, Range> probMap;

    public Zipf(int maxValue) {
        probMap = new TreeMap<Integer, Range>();
        r = new Random();

        //calculate the demoninator of the zipf given the size
        distSize = maxValue;
        denominator = 0;
        for(double i = 1; i < distSize + 1; i++) {
            denominator += (1/i);
        }

        double runningSum = 0.0;
        for(int i = 1; i <= distSize; i++) {
            //map all possible doubles from 0 to 1 to a value corresponding to
            //one of the values in the zipf sequence.
            if(i == 1) {
                probMap.put(1, new Range(runningSum, (1/denominator)));
                runningSum += 1/denominator;
            } else if(i == distSize) {
                probMap.put(distSize, new Range(runningSum, 1));
            } else {
                double probability = (1.0/i)/denominator;
                probMap.put(i, new Range(runningSum, runningSum + probability));
                runningSum += probability;
            }
        }
    }

    public int next() {
        //generate a random double
        double key = r.nextDouble();

        //check the values in the map to find the value that is maps to
        for(int i = 1; i <= distSize; i++) {
            Range range = probMap.get(i);
            if(key >= range.getLower() && key < range.getUpper()) {
                return i;
            }
        } 

        return 0;
    }

    public void printMap() {
        System.out.println("====================Map values====================");
        for(int i = 1; i <= distSize; i++) {
            double upper = probMap.get(i).getUpper();
            double lower = probMap.get(i).getLower();
            System.out.println(i + " is mapped to range " + lower + " to " + upper + " (prob is " + (upper - lower) + ")");
        }
    }
}