package org.telephone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class Main {
	
	@Test
	public void twoNumbersAreNotConsistent() {
		String bob = "91125426";
		String emergency = "911";
		
		assertThat(ConsistencyManager.isConsistent(bob, emergency), equalTo(false));
	}
	
	@Test
	public void twoNumbersAreConsistent() {
		String bob = "91125426";
		String alice = "97 625 992";
				
		assertThat(ConsistencyManager.isConsistent(bob, alice), equalTo(true));
	}
		
}
