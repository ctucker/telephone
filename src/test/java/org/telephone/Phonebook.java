package org.telephone;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Phonebook {
	
	private Map<String, String> fEntries = Maps.newHashMap();

	public Phonebook() {
	}
	
	public Phonebook(Map<String, String> entries) {
		fEntries = entries;
	}
	
	public Phonebook(String... entries) {
		if (entries.length % 2 != 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < entries.length; i += 2) {
			String key = entries[i];
			String value = entries[i + 1];
			fEntries.put(key, value);
		}
	}
	
	public boolean isConsistent() {
		List<String> remaining = Lists.newArrayList(fEntries.values());
		while (!remaining.isEmpty()) {
			String testValue = canonicalizeNumber(remaining.remove(0));
			for (String value : remaining) {
				String valueCanonical = canonicalizeNumber(value);
				if (testValue.startsWith(valueCanonical) || valueCanonical.startsWith(testValue)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String canonicalizeNumber(String number) {
		return number.replaceAll("\\s+", "");
	}
	
}
