package be.ordina.s2j.util;

import lombok.SneakyThrows;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import be.ordina.s2j.model.Beer;

/**
 * Test class for {@link JsonUtil}
 */
public class JsonUtilTest {
	
	private static final String FILE_NAME = "expectedOutput.json";

	private static final int ID = 1337;
	private static final String BRAND = "Guiness";
	
	/**
	 * Test method for toJson
	 */
	@Test
	@SneakyThrows
	public void testToJson() {
		Beer beer = new Beer();
		beer.setId(ID);
		beer.setBrand(BRAND);
		
		String jsonOutput = JsonUtil.toJson(beer);
		
		String expectedOutput = IOUtils.toString(this.getClass().getResourceAsStream(FILE_NAME));
		
		Assert.assertEquals(expectedOutput, jsonOutput);
	}

}
