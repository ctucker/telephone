package org.telephone;

public class ConsistencyManager {

	public static Boolean isConsistent(String x, String y) {
		return !x.startsWith(y);
	}

}
