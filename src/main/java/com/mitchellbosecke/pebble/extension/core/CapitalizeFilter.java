package com.mitchellbosecke.pebble.extension.core;

import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.extension.Filter;

public class CapitalizeFilter implements Filter {

	@Override
	public List<String> getArgumentNames() {
		return null;
	}

	@Override
	public Object apply(Object input, Map<String, Object> args) {
		if (input == null) {
			return null;
		}
		String value = (String) input;

		if (value == null || (value.length() == 0)) {
			return value;
		}

		char firstCharacter = value.charAt(0);
		if (Character.isTitleCase(firstCharacter)) {
			return value;
		}
		return new StringBuilder(value.length()).append(Character.toTitleCase(firstCharacter))
				.append(value.substring(1)).toString();
	}

}
