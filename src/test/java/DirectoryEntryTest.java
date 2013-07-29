import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class DirectoryEntryTest {

	@Test
	public void normalizes_phone_number_to_contain_only_digits_when_constructed_from_map_entry() {
		ImmutableMap<String, String> entries = ImmutableMap.of("Bob", "(123) 456-7890");
		Map.Entry<String, String> entry = entries.entrySet().iterator().next();

		DirectoryEntry directoryEntry = new DirectoryEntry(entry);

		assertThat(directoryEntry.getPhoneNumber(), is(equalTo("1234567890")));
	}

	@Test
	public void normalizes_phone_number_to_contain_only_digits_when_constructed_from_name_and_number() {
		DirectoryEntry directoryEntry = new DirectoryEntry("Bob", "(123) 456-7890");

		assertThat(directoryEntry.getPhoneNumber(), is(equalTo("1234567890")));
	}


}
