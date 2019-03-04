import java.util.Random;

public class Zipf {

    private double distSize;
    private double denominator;

    public Zipf(int upperBound) {
        r = new Random();

        //calculate the demoninator of the zipf given the size
        distSize = upperBound;
        denominator = 0;
        for(double i = 1; i < distSize + 1; i++) {
            denominator += (1/i);
        }
    }
    
    

}