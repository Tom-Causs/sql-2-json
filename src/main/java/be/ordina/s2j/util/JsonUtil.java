package be.ordina.s2j.util;

import lombok.SneakyThrows;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for mapping objects into JSON format
 */
public final class JsonUtil {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * private constructor
	 */
	private JsonUtil() {
		super();
	}
	
	/**
	 * Convert object into JSON string
	 * @param obj Object to map
	 */
	@SneakyThrows
	public static String toJson(Object obj) {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	}
	
}
