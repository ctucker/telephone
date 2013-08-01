package telephone;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@RunWith(Parameterized.class)
public class SingleNumberIsConsistent {
	@Parameters
	public final static List<Object[]> names() {
		List<Object[]> params = Lists.newArrayList();

		params.add(new String[] { "Jack" });
		params.add(new String[] { "Joe" });
		params.add(new String[] { "Bob" });
		params.add(new String[] { "Elmer" });
		params.add(new String[] { "Nobody" });
		params.add(new String[] { "Emergency" });
		params.add(new String[] { "What" });

		return params;
	}

	private final String name;

	public SingleNumberIsConsistent(String name) {
		this.name = name;
	}

	@Test
	public void anySingleNumberIsConsistent() {
		Map<String, String> map = Maps.newHashMap();
		map.put(name, "911");

		PhoneDialer numbers = new PhoneDialer(map);
		assertTrue(numbers.isConsistent());
	}
}
