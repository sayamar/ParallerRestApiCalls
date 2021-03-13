/**
 * 
 */
package com.tcs.angular.angular4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.angular4.dto.Country;
import com.tcs.angular.angular4.service.CountryClient;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Maruthi Sayampu
 *
 */
@RestController
public class CountryController {

	private final CountryClient countryClient;

	public CountryController(CountryClient countryClient) {
		super();
		this.countryClient = countryClient;
	}

	@ApiOperation(httpMethod = "GET", value = "Get all European and French speaking countries", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Countries not found"),
			@ApiResponse(code = 500, message = "The countries could not be fetched") })
	@GetMapping("/getCtyList")
	public List<String> getAllEuropeanFrenchSpeakingCountries() {
		List<Country> countriesByLanguage = countryClient.getCountriesByLanguage("en");
		List<Country> countriesByRegion = countryClient.getCountriesByRegion("asia");

		List<String> europeanFrenchSpeakingCountries = new ArrayList<>(
				countriesByLanguage.stream().map(Country::getName).collect(Collectors.toList()));
		europeanFrenchSpeakingCountries
				.retainAll(countriesByRegion.stream().map(Country::getName).collect(Collectors.toList()));

		return europeanFrenchSpeakingCountries;
	}

}
