package com.rickywong.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rickywong.countries.repositories.CityRepo;
import com.rickywong.countries.repositories.CountryRepo;
import com.rickywong.countries.repositories.LanguageRepo;

@Service
public class ApiService {

	private final CountryRepo cr;
	private final LanguageRepo lr;
	private final CityRepo cR;
	
	@Autowired
	public ApiService(CountryRepo cr,
			LanguageRepo lr,
			CityRepo cR) {
		this.cr = cr;
		this.lr = lr;
		this.cR = cR;
	}
	
	public List<Object[]> countriesSpeakSlovene() {
		return cr.allCountriesWhereLanguageSlovene();
	}
	
	public List<String> findAllCountriesByNames() {
		return cr.findAllCountriesByNames();
	}
	
	public List<Object[]> countryNames() {
		return cr.numberCitiesByCountry();
	}
	
	public List<Object[]> mexicoCitiesPopHigherHalfMillion() {
		return cR.citiesInMexicoPopHalfMillion();
	}
	
	public List<Object[]> languagesPercentGreater89() {
		return lr.languagesPercentGreater89();
	}
	
	public List<Object[]> countriesSurfaceAreaBelow501PopGreater100000() {
		return cr.countriesSurfaceAreaBelow501PopGreater100000();
	}
	
	public List<Object[]> countriesConstitutionalMonarchy() {
		return cr.countriesConstitutionalMonarchy();
	}
	
	public List<Object[]> argentinaCitiesInBuenosAires() {
		return cR.argentinaCitiesInBuenosAires();
	}
	
	public List<Object[]> summaryCountriesInRegion() {
		return cr.summaryCountriesInRegion();
	}
}