import java.util.ArrayList;

public class P108 {
	public static void main(String args[]) {
		int TARGET = 1000;
		for (int i = TARGET + 1;; i++) {
			ArrayList<Factor> primeFactors = findPrimeFactors(i);
			int solutionNum = 1;
			for (int j = 0; j < primeFactors.size(); j++) {
				solutionNum *= (2 * primeFactors.get(j).exponent + 1);
			}
			solutionNum = (solutionNum + 1) / 2;
			if (solutionNum > TARGET) {
				System.out.println(i);
				break;
			}
		}
	}

	static ArrayList<Factor> findPrimeFactors(int number) {
		ArrayList<Factor> primeFactors = new ArrayList<Factor>();
		for (int i = 2; i * i <= number; i++) {
			if (isPrime(i) && number % i == 0) {
				int count = 0;
				while (number % i == 0) {
					number /= i;
					count++;
				}
				primeFactors.add(new Factor(i, count));
			}
		}
		if (number > 1) {
			primeFactors.add(new Factor(number, 1));
		}
		return primeFactors;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class Factor {
	int factor;
	int exponent;

	Factor(int theFactor, int theExponent) {
		this.factor = theFactor;
		this.exponent = theExponent;
	}
}