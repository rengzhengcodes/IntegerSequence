import java.util.ArrayList;
public class RangeTester {

	public static void main(String[] args) {
		boolean failure = false;
		failure = failure || constructorTester(1000);
		failure = failure || hasNextTester(1000);

		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("Coal for you!");
		} else {
			System.out.println("Happy Holidays!");
		}
	}

	private static void tester(String test) {
		System.out.println("\n ~~~ " + test + "~~~\n");
	}

	private static int randInt(int end) {
		return randInt(0, end);
	}

	private static int randInt(int start, int end) {
		return (int)(Math.random()* (end - start)) + start;
	}

	private static void passMessage(int testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void passMessage(String testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void methodMessage(String method, boolean failure) {
		if (failure) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

	public static boolean constructorTester(int tests) {
		String method = "constructorTester";
		tester(method);
		boolean fail = false;
		//should return true
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				//passMessage(test);
			} catch (Exception e) {
				e.printStackTrace();
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			}

			end = start - (1 + randInt(10));
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				fail = true;
				System.out.println("Expected error!");
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			} catch (Exception e) {
				//passMessage(test);
			}

		}

		methodMessage(method, fail);
		return fail;
	}

	public static boolean hasNextTester(int tests) {
		tester("hasNextTester");
		boolean fail = false;
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			Range r = new Range(start, end);
			ArrayList<Integer> equivalent = new ArrayList<Integer>();

			for (int n = start; n <= end; n++) {
				equivalent.add(n);
			}

			for (int n : equivalent) {
				int current = n;
				if (n != equivalent.get(equivalent.size() - 1)) {
					if (r.hasNext()) {
						current = r.next();
						//passMessage(test);
					} else {
						fail = true;
						System.out.println("Start: " + start);
						System.out.println("End: " + end);
						System.out.println("Current: " + current);
					}
				} else {
					if (!r.hasNext()) {
						//passMessage(test);
					} else {
						fail = true;
						System.out.println("Start: " + start);
						System.out.println("End: " + end);
						System.out.println("Current: " + current);
					}
				}
			}
		}
		methodMessage("hasNextTester", fail);
		return fail;
	}

}