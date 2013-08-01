package telephone;

import java.util.Map;

public class PhoneDialer {
	private final Map<String, String> map;

	public PhoneDialer(Map<String, String> map) {
		this.map = map;
	}

	public boolean isConsistent() {
		for (Map.Entry<String, String> entry1 : map.entrySet()) {
			if (containsPrefix(entry1.getKey(), entry1.getValue()))
				return false;
		}

		return true;
	}

	private boolean containsPrefix(String excludedKey, String value) {
		for (Map.Entry<String, String> entry2 : map.entrySet()) {
			if (!entry2.getKey().equals(excludedKey)) {
				if (entry2.getValue().replaceAll("\\s+", "").startsWith(value.replaceAll("\\s+", "")))
					return true;
			}
		}

		return false;
	}
}
