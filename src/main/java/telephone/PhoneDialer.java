package telephone;

import java.util.Map;

public class PhoneDialer {
	final Map<String, String> map;

	public PhoneDialer(Map<String, String> map) {
		this.map = new PhoneNormalizer().normalize(map);
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
				if (entry2.getValue().startsWith(value))
					return true;
			}
		}

		return false;
	}

}
