package be.ordina.s2j.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.ordina.s2j.config.MainConfig;
import be.ordina.s2j.model.Beer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class })
public class BeerRepositoryTest {

	private static final String BRAND = "Guiness";
	
	@Autowired
	private BeerRepository beerRepo;
	
	@Test
	public void testFindAll() {
		Assert.assertNotNull(beerRepo);
		
		Assert.assertTrue(beerRepo.findAll().size() > 0);
	}
	
	@Test
	public void testCRUD() {
		Beer beer = new Beer();
		beer.setBrand(BRAND);
		
		Assert.assertEquals(0, beer.getId());
		
		// create entity
		beerRepo.save(beer);
		
		int generatedId = beer.getId();
		// check that entity gets ID from DB
		Assert.assertNotEquals(0, generatedId);
		
		// read created entity from DB
		Beer beerFromDb = beerRepo.findOne(generatedId);
		
		Assert.assertEquals(BRAND, beer.getBrand());
		
		// delete created entity from DB
		beerRepo.delete(beerFromDb);
		
		Beer deletedBeer = beerRepo.findOne(generatedId);
		
		Assert.assertNull(deletedBeer);
	}
	
}
