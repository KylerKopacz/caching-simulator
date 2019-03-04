public class UniformTester {
    public static void main(String[] args) {
        Uniform u = new Uniform();
        for(int i = 0; i < 1000; i++) {
            System.out.print(u.next() + " ");
        }
    }
}