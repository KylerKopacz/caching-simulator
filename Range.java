public class Range {
    private double lowerBound;
    private double upperBound;

    public Range(double lower, double upper) {
        lowerBound = lower;
        upperBound = upper;
    }

    public double getLower() {
        return lowerBound;
    } 

    public double getUpper() {
        return upperBound;
    }
}