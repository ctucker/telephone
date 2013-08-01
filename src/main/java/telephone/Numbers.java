package telephone;

import java.util.Map;

public class Numbers {
	private final Map<String, String> map;

	public Numbers(Map<String, String> map) {
		this.map = map;
	}

	public boolean isConsistent() {
		return !map.containsKey("Bob") || !map.containsKey("Emergency");
	}
}
