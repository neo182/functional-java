package no.knowit.demo.funcjava.functechniques;

public class PureFunctionDemo {
	// Pure function
	public double calculateBonusPure(int numSales) {
		return (numSales > 100) ? 0.10 * numSales : 0;
	}

	// impure function
	int limit = 100;
	public double calculateBonusImpure(int numSales) {
		return (numSales > limit) ? 0.10 * numSales : 0;
	}

}
