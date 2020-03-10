package no.knowit.demo.funcjava.lambda;

public class LambdaUnderHood {
	public static void main(String[] args) {
		//Runnable runnable = () -> System.out.println("hello!");
		//runnable.run();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hello!");
			}
		};
		
		runnable.run();
	}
}
