package be.ordina.s2j.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
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

	private static final String FILE_NAME = "output.json";
	
	@Autowired
	private BeerRepository beerRepository;
	
	/**
	 * Exports {@link Beer} entities into JSON file on disk
	 */
	@Override
	public void export() {
		List<Beer> beerList = beerRepository.findAll();
		int count = beerList.size();
		
		String json = JsonUtil.toJson(beerList);
		
		try {
			Files.write(Paths.get("./" + FILE_NAME), json.getBytes());
			log.info("Exporting {} entities into JSON file '{}'", count, FILE_NAME);
		} catch (IOException e) {
			log.error("Failed writing to the file");
		}
	}

}
