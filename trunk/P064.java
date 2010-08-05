import java.math.BigInteger;
import java.util.ArrayList;

public class P064 {
	public static void main(String args[]) {
		int count = 0;
		for (int i = 1; i <= 10000; i++) {
			int numberInt = (int) Math.sqrt(i);
			if (numberInt * numberInt == i) {
				continue;
			}
			ArrayList<Fraction> fractions = new ArrayList<Fraction>();
			BigInteger up1 = BigInteger.ONE;
			BigInteger up2 = new BigInteger(-numberInt + "");
			BigInteger down = BigInteger.ONE;
			fractions.add(new Fraction(up1, up2, down));
			while (true) {
				BigInteger nextUp1 = up1.multiply(down);
				BigInteger nextUp2 = up2.negate().multiply(down);
				BigInteger nextDown = up1.multiply(up1)
						.multiply(new BigInteger(i + ""))
						.subtract(up2.multiply(up2));
				BigInteger common = nextUp1.gcd(nextUp2).gcd(nextDown);
				nextUp1 = nextUp1.divide(common);
				nextUp2 = nextUp2.divide(common);
				nextDown = nextDown.divide(common);
				int intPart = 0;
				while (nextUp1
						.multiply(nextUp1)
						.multiply(new BigInteger(i + ""))
						.compareTo(
								nextDown.subtract(nextUp2).multiply(
										nextDown.subtract(nextUp2))) >= 0) {
					nextUp2 = nextUp2.subtract(nextDown);
					intPart++;
				}
				up1 = nextUp1;
				up2 = nextUp2;
				down = nextDown;
				Fraction f = new Fraction(up1, up2, down);
				int index = fractions.indexOf(f);
				if (index == -1) {
					fractions.add(f);
				} else {
					if ((fractions.size() - index) % 2 == 1) {
						count++;
					}
					break;
				}
			}
		}
		System.out.println(count);
	}
}

class Fraction {
	BigInteger up1;
	BigInteger up2;
	BigInteger down;

	Fraction(BigInteger theUp1, BigInteger theUp2, BigInteger theDown) {
		this.up1 = theUp1;
		this.up2 = theUp2;
		this.down = theDown;
	}

	public boolean equals(Object obj) {
		Fraction another = (Fraction) obj;
		return this.up1.compareTo(another.up1) == 0
				&& this.up2.compareTo(another.up2) == 0
				&& this.down.compareTo(another.down) == 0;
	}
}