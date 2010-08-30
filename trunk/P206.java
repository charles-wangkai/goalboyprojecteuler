public class P206 {
	public static void main(String args[]) {
		long base = 1020304050607080900L;
		for (int a1 = 0; a1 <= 9; a1++) {
			for (int a2 = 0; a2 <= 9; a2++) {
				for (int a3 = 0; a3 <= 9; a3++) {
					for (int a4 = 0; a4 <= 9; a4++) {
						for (int a5 = 0; a5 <= 9; a5++) {
							for (int a6 = 0; a6 <= 9; a6++) {
								for (int a7 = 0; a7 <= 9; a7++) {
									for (int a8 = 0; a8 <= 9; a8++) {
										for (int a9 = 0; a9 <= 9; a9++) {
											long number = base + a1
													* 100000000000000000L + a2
													* 1000000000000000L + a3
													* 10000000000000L + a4
													* 100000000000L + a5
													* 1000000000L + a6
													* 10000000L + a7 * 100000L
													+ a8 * 1000L + a9 * 10L;
											long root;
											if ((root = isSquare(number)) > 0) {
												System.out.println(root);
												System.exit(0);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	static long isSquare(long number) {
		long root = Math.round(Math.sqrt(number));
		if (root * root == number) {
			return root;
		} else {
			return -1;
		}
	}
}
