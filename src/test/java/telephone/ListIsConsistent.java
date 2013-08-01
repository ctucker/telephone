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

		Numbers numbers = new Numbers(map);
		assertFalse(numbers.isConsistent());
	}

	@Test
	public void bobAliceIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Bob", "91125426");
		map.put("Alice", "97 625 992");

		Numbers numbers = new Numbers(map);
		assertTrue(numbers.isConsistent());
	}

	@Test
	public void aliceEmergencyIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put("Emergency", "911");
		map.put("Alice", "97 625 992");

		Numbers numbers = new Numbers(map);
		assertTrue(numbers.isConsistent());
	}

}
