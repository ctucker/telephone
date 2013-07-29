import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class TelephoneDirectoryTest {

	@Test
	public void emptyDirectoryIsConsistent() {
		TelephoneDirectory directory = directoryOf();
		assertThat(directory.isConsistent(), is(true));
	}


	@Test
	public void directoryWithSingleEntryIsConsistent() {
		TelephoneDirectory directory = directoryOf("Bob", "9");
		assertThat(directory.isConsistent(), is(true));
	}

	@Test
	public void directoryWithMultipleDistinctEntriesIsConsistent() {
		TelephoneDirectory directory = directoryOf("Bob", "9",
		                                           "Alice", "8",
		                                           "Carol", "7");
		assertThat(directory.isConsistent(), is(true));
	}


	@Test
	public void directoryWithExactlyEqualEntriesIsInconsistent() {
		TelephoneDirectory directory = directoryOf("Bob"  , "9",
		                                           "Alice", "9");
		assertThat(directory.isConsistent(), is(false));
	}

	@Test
	public void directoryWithAlicesNumberAsASingleDigitPrefixOfBobsIsInconsistent() {
		TelephoneDirectory directory = directoryOf("Alice", "9",
		                                           "Bob", "91");
		assertThat(directory.isConsistent(), is(false));
	}

	@Test
	public void directoryWithBobsNumberAsSingleDifitPrefixOfAlicesIsInconsistent() {
		TelephoneDirectory directory = directoryOf("Alice", "91",
		                                           "Bob", "9");
		assertThat(directory.isConsistent(), is(false));
	}

	@Test
	public void phoneNumberWithSpacesInItIsStillInconsistentIfTheDigitsMatch() {
		TelephoneDirectory directory = directoryOf("Alice", "9 1",
		                                           "Bob", "91");
		assertThat(directory.isConsistent(), is(false));
	}


	private TelephoneDirectory directoryOf(String ... entries) {
		if (entries.length % 2 != 0) {
			throw new IllegalArgumentException("Entries must be even in size");
		}
		ImmutableMap.Builder<String, String> mapBuilder = ImmutableMap.builder();
		for (int i = 0; i < entries.length; i += 2) {
			mapBuilder.put(entries[i], entries[i+1]);
		}
		return new TelephoneDirectory(mapBuilder.build());
	}

}
