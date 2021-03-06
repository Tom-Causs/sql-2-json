package be.ordina.s2j.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ordina.s2j.model.Beer;

/**
 * Repository for {@link Beer}
 */
public interface BeerRepository extends JpaRepository<Beer, Integer> {

	
}
