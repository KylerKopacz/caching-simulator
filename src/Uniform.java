import java.util.Random;
/** A number generator that generates requests based on a Uniform distribution
 * @author Kyler Kopacz
 * @author http://kylerkopacz.me
 */
public class Uniform {
    private Random r;
    private int upperBound;

    /** Constructor for the Uniform number generator
     * @param maxValue The max value that can be generated.
     */
    public Uniform(int maxValue) {
        r = new Random();
        upperBound = maxValue;
    }

    /** Draw a number from a Uniform distribution.
     * @return The drawn number.
     */
    public int next() {
        int toReturn = r.ints(1,1, upperBound).toArray()[0];
        return toReturn;
    }
}