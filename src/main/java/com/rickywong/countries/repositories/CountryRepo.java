package com.rickywong.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rickywong.countries.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
	List<Country> findAll();
	
	@Query("SELECT c.name from Country c")
	List<String> findAllCountriesByNames();
	
	@Query(value = "SELECT * FROM countries", nativeQuery = true)
	List<Country> findAllCountriesWithId();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> allCountriesWhereLanguageSlovene();
	
	@Query("SELECT c.name, c.region, COUNT(ci) FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci) DESC")
	List<Object[]> numberCitiesByCountry();
	
	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.surfaceArea < 501 and c.population > 100000")
	List<Object[]> countriesSurfaceAreaBelow501PopGreater100000();
	
	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy > 75")
	List<Object[]> countriesConstitutionalMonarchy();
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> summaryCountriesInRegion();
}