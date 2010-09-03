import java.util.ArrayList;

public class P108 {
	public static void main(String args[]) {
		int TARGET = 1000;
		for (int i = TARGET + 1;; i++) {
			ArrayList<Factor> primeFactors = findPrimeFactors(i);
			doubleExponent(primeFactors);
			if (solutionNum(primeFactors, 0, 1, i) > TARGET) {
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

	static void doubleExponent(ArrayList<Factor> primeFactors) {
		for (int i = 0; i < primeFactors.size(); i++) {
			primeFactors.get(i).exponent *= 2;
		}
	}

	static int solutionNum(ArrayList<Factor> primeFactors, int index,
			int current, int limit) {
		if (index == primeFactors.size()) {
			return 1;
		} else {
			int temp = 1;
			int sum = 0;
			for (int i = 0; i <= primeFactors.get(index).exponent
					&& current * temp <= limit; i++) {
				sum += solutionNum(primeFactors, index + 1, current * temp,
						limit);
				temp *= primeFactors.get(index).factor;
			}
			return sum;
		}
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