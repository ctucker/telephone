package telephone;

import java.util.Map;

public class PhoneDialer {
	private final Map<String, String> map;

	public PhoneDialer(Map<String, String> map) {
		this.map = map;
	}

	public boolean isConsistent() {
		for (Map.Entry<String, String> entry1 : map.entrySet()) {
			for (Map.Entry<String, String> entry2 : map.entrySet()) {
				if (!entry2.getKey().equals(entry1.getKey())) {
					if (entry2.getValue().startsWith(entry1.getValue()))
						return false;
				}
			}
		}

		return true;
	}
}
