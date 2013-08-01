package telephone;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhoneNormalizerTest {
	@Test
	public void normalizeString() {
		assertEquals("123", new PhoneNormalizer().normalize("1 2 3"));
	}
}
