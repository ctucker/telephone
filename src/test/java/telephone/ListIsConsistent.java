package telephone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class ListIsConsistent {
	@Test
	public void exampleListIsInconsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Bob", "91125426");
		map.put("Alice", "97 625 992");
		map.put("Emergency", "911");

		PhoneDialer numbers = new PhoneDialer(map);
		assertFalse(numbers.isConsistent());
	}

	@Test
	public void nonSharedPrefixAreConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Bob", "911");
		map.put("Alice", "912");

		PhoneDialer numbers = new PhoneDialer(map);
		assertTrue(numbers.isConsistent());
	}

	@Test
	public void sameNumberIsInconsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Bob", "911");
		map.put("Alice", "911");

		PhoneDialer numbers = new PhoneDialer(map);
		assertFalse(numbers.isConsistent());
	}

	@Test
	public void bobAliceIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Bob", "91125426");
		map.put("Alice", "97 625 992");

		PhoneDialer numbers = new PhoneDialer(map);
		assertTrue(numbers.isConsistent());
	}

	@Test
	public void aliceEmergencyIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Emergency", "911");
		map.put("Alice", "97 625 992");

		PhoneDialer numbers = new PhoneDialer(map);
		assertTrue(numbers.isConsistent());
	}

	@Test
	public void anySingleNumberIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Jack", "911");

		PhoneDialer numbers = new PhoneDialer(map);
		assertTrue(numbers.isConsistent());
	}

}
