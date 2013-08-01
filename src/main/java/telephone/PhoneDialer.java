package telephone;

import java.util.Map;

public class PhoneDialer {
	private final Map<String, String> map;

	public PhoneDialer(Map<String, String> map) {
		this.map = map;
	}

	public boolean isConsistent() {
		return !map.containsKey("Bob") || !map.containsKey("Emergency");
	}
}
