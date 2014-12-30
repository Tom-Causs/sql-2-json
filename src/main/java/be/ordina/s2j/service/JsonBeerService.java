package be.ordina.s2j.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import be.ordina.s2j.model.Beer;
import be.ordina.s2j.repository.BeerRepository;
import be.ordina.s2j.util.JsonUtil;

/**
 * Service for exporting {@link Beer} entities into JSON format
 */
@Service
@Slf4j
public class JsonBeerService implements BeerService {

	private static final String PATHNAME = "s2j.json.pathname";
	private static final String DEFAULT_PATHNAME = ".";
	private static final String FILENAME = "s2j.json.filename";
	private static final String DEFAULT_FILENAME = "output.json";
	
	private static final String INDEX_NAME = "inventory";
	private static final String DOC_TYPE = "beer";

	@Autowired
	private Environment env;
	
	@Autowired
	private BeerRepository beerRepository;
	
	/**
	 * Exports {@link Beer} entities into JSON file on disk
	 */
	@Override
	public void export() {
		List<Beer> beerList = beerRepository.findAll();
		
		writeToFile(beerList);
	}
	
	private void writeToFile(List<Beer> list) {
		int count = list.size();
		
		String pathname = env.getProperty(PATHNAME, DEFAULT_PATHNAME);
		String filename = env.getProperty(FILENAME, DEFAULT_FILENAME);
		String fullPath = pathname + File.separator + filename;

		StringBuilder sb = new StringBuilder();
		for (Beer beer : list) {
			sb.append("{ \"index\" : { \"_index\" : \"" + INDEX_NAME + "\", \"_type\" : \"" + DOC_TYPE + "\" } }\n");
			sb.append(JsonUtil.toJson(beer) + "\n");
		}
		
		try {
			Files.write(Paths.get(fullPath), sb.toString().getBytes());
			log.info("Exporting {} entities into JSON file '{}'", count, fullPath);
		} catch (IOException e) {
			log.error("Failed writing to the file '{}'", fullPath);
		}
	}

}
