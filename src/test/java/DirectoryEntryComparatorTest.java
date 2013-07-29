import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DirectoryEntryComparatorTest {

	@Test
	public void entriesWithEqualValuesCompareAsEqual() {

		DirectoryEntry left = new DirectoryEntry("Bob", "123");
		DirectoryEntry right = new DirectoryEntry("Alice", "123");

		assertThat(new DirectoryEntryComparator().compare(left, right), is(equalTo(0)));
	}

	@Test
	public void leftEntryThatIsLexicographicallySmallerSortsLower() {

		DirectoryEntry left = new DirectoryEntry("Bob", "123");
		DirectoryEntry right = new DirectoryEntry("Alice", "456");

		assertThat(new DirectoryEntryComparator().compare(left, right), is(lessThan(0)));
	}

	@Test
	public void rightEntryThatIsLexicographicallySmallerSortsLower() {
		DirectoryEntry left = new DirectoryEntry("Bob", "456");
		DirectoryEntry right = new DirectoryEntry("Alice", "123");

		assertThat(new DirectoryEntryComparator().compare(left, right), is(greaterThan(0)));
	}

}
