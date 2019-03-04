public class RequestGeneratorTester {
	public static void main(String[] args) {
		RequestGenerator rg = new RequestGenerator();
		for(int i = 0; i < 1000; i++) {
			System.out.print(rg.generateRequest() + " ");
		}
	}
}
