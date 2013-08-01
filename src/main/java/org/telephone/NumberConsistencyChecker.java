package org.telephone;

public class NumberConsistencyChecker {

	public static Boolean isConsistent(String x, String y) {
		return !x.startsWith(y);
	}

}
