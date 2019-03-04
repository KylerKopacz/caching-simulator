import java.util.Random;

public class Uniform {
    Random r;
    int upperBound;

    public Uniform(int upperBound) {
        r = new Random();
        this.upperBound = upperBound;
    }

    public int next() {
        int toReturn = r.ints(1,1, upperBound).toArray()[0];
        return toReturn;
    }
}