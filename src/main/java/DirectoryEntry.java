import java.util.Map;

public class DirectoryEntry {
	private final String name;
	private final String phoneNumber;

	public DirectoryEntry(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = normalizePhoneNumber(phoneNumber);
	}

	public DirectoryEntry(Map.Entry<String, String> mapEntry) {
		this.name = mapEntry.getKey();
		this.phoneNumber = normalizePhoneNumber(mapEntry.getValue());
	}

	private String normalizePhoneNumber(String value) {
		return value.replaceAll("[^\\d]", "");
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


}
