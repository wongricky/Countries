package com.rickywong.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rickywong.countries.models.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
	List<City> findAll();
	
	@Query("SELECT ci.name, ci.population FROM City ci JOIN ci.country c WHERE c.name  = 'Mexico' AND ci.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> citiesInMexicoPopHalfMillion();
	
	@Query("SELECT ci.name, ci.district, ci.population FROM City ci")
	List<Object[]> argentinaCitiesInBuenosAires();
}
