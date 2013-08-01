package telephone;

import java.util.Map;

import com.google.common.collect.Maps;

public class PhoneNormalizer {
	public Map<String, String> normalize(Map<String, String> input) {
		Map<String, String> output = Maps.newHashMap();
		for (Map.Entry<String, String> entry : input.entrySet())
			output.put(entry.getKey(), normalize(entry.getValue()));
		return output;
	}

	String normalize(String number) {
		return number.replaceAll("\\s+", "");
	}
}
