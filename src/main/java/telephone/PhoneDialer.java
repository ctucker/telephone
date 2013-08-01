package telephone;

import java.util.Map;

import com.google.common.collect.Maps;

public class PhoneDialer {
	final Map<String, String> map;

	public PhoneDialer(Map<String, String> map) {
		this.map = normalize(map);
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

	String normalize(String number) {
		return number.replaceAll("\\s+", "");
	}

	Map<String, String> normalize(Map<String, String> input) {
		Map<String, String> output = Maps.newHashMap();
		for (Map.Entry<String, String> entry : input.entrySet())
			output.put(entry.getKey(), normalize(entry.getValue()));
		return output;
	}
}
