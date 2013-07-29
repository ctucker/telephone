import java.util.Comparator;

public class DirectoryEntryComparator implements Comparator<DirectoryEntry> {

	@Override
	public int compare(DirectoryEntry left, DirectoryEntry right) {
		return left.getPhoneNumber().compareTo(right.getPhoneNumber());
	}
}
