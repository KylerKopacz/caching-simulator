import java.util.Random;
/** A number generator that generates requests based on a Zipf distribution
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class Zipf {

    private int distSize;
    private double denominator;
    private Random r;
    private double[] probMap;

    /** Constructor for the Uniform number generator
     * @param maxValue The max value that can be generated.
     */
    public Zipf(int maxValue) {
        r = new Random();
        distSize = maxValue;

        //making the probmap 1 more than the max value so we can skip 0 and assign
        //probabilities from index 1 - maxvalue
        probMap = new double[distSize + 1];

        //calculate the demoninator of the zipf given the size
        denominator = 0;
        for(double i = 1; i < distSize + 1; i++) {
            denominator += (1/i);
        }

        for(int i = 1; i < probMap.length; i++) {
            probMap[i] = ((1.0/i)/denominator);
        }
    }

    /** Draw a number from a Zipf distribution.
     * @return The drawn number.
     */
    public int next() {
        //generate a random double
        double nextValue = r.nextDouble(); 

        //now we need to find what this value maps to
        double runningSum = 0.0;
        for(int i = 1; i < probMap.length; i++) {
            runningSum += probMap[i];
            if(nextValue < runningSum) {//we have found the value
                return i;
            }
        }

        //we should never get to this point
        return 0;
    }

    /** Prints the mapped probabilites of the Zipf distribution */
    public void printMap() {
        System.out.println("====================Map values====================");
        for(int i = 1; i < probMap.length; i++) {
            System.out.println(i + " occurs with prob. " + probMap[i]);
        }
    }
}