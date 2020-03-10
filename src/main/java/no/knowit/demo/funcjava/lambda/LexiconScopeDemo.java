package no.knowit.demo.funcjava.lambda;

public class LexiconScopeDemo {
	static String location = "World";
	
	public static void main(String[] args) {
		final String location = "Norway";
		
		Runnable runnable1 = new Runnable() {
		    public void run() {
				System.out.println("Hello, "+ location + "!");
			}
		};
		
		runnable1.run();
		 
	}
}
