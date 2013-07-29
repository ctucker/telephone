import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class TelephoneDirectory {
	private ImmutableList<DirectoryEntry> directoryEntries;

	public TelephoneDirectory(ImmutableMap<String, String> phoneNumbers) {
		List<DirectoryEntry> entryList = Lists.newArrayListWithCapacity(phoneNumbers.size());
		for (Map.Entry<String, String> entry : phoneNumbers.entrySet()) {
			entryList.add(new DirectoryEntry(entry));
		}
		this.directoryEntries = Ordering.from(new DirectoryEntryComparator()).immutableSortedCopy(entryList);
	}

	public boolean isConsistent() {
		for (int i = 0; i < directoryEntries.size() - 1; ++i) {
			if (entryAtIndexIsPrefixOfNextEntry(i)) {
				return false;
			}
		}
		return true;
	}

	private boolean entryAtIndexIsPrefixOfNextEntry(int i) {
		return directoryEntries.get(i+1).getPhoneNumber().contains(directoryEntries.get(i).getPhoneNumber());
	}

}
