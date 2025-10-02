// CS108 HW1 -- String static methods

import java.util.HashSet;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int maxRun = 1;
		int currentRun = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				currentRun++;
			} else {
				currentRun = 1;
			}
			if (currentRun > maxRun) {
				maxRun = currentRun;
			}
		}
		return maxRun;
	}


	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				int count = Character.getNumericValue(ch);
				if (i + 1 < str.length()) {
					char next = str.charAt(i + 1);
					for (int j = 0; j < count; j++) {
						result.append(next);
					}
				}
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (len > a.length() || len > b.length()) {
			return false;
		}
		HashSet<String> seen = new HashSet<>();
		for (int i = 0; i <= a.length() - len; i++) {
			seen.add(a.substring(i, i + len));
		}
		for (int i = 0; i <= b.length() - len; i++) {
			if (seen.contains(b.substring(i, i + len))) {
				return true;
			}
		}
		return false;
	}
}
