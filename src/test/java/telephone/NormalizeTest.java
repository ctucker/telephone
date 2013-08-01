package telephone;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

public class NormalizeTest {
	@Test
	public void normalizeString() {
		assertEquals("123", new PhoneDialer(Collections.<String, String> emptyMap()).normalize("1 2 3"));
	}
}
