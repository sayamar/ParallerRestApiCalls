/**
 * 
 */
package com.tcs.angular.angular4.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.angular4.dto.Country;
import com.tcs.angular.angular4.service.CountryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Maruthi Sayampu
 *
 */
@RestController
@RequestMapping("/counties/v1")
public class AsyncRestController {

	private CountryService countryService;

	public AsyncRestController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@ApiOperation(httpMethod = "GET", value = "Get all European and French speaking countries", response = String.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Countries not found"),
	@ApiResponse(code = 500, message = "The countries could not be fetched") })
	@GetMapping("getCountryList")
	public List<String> getAllFrenchSpeakingCountries() throws Throwable{

		CompletableFuture<List<Country>> frList = countryService.getCountriesByLanguage("fr");
		CompletableFuture<List<Country>> regionList = countryService.getCountriesByRegion("europe");
		List<String> frenchSpeakingCountries = null;
		try {
			frenchSpeakingCountries = new ArrayList<>(
					frList.get().stream().map(Country::getName).collect(Collectors.toList()));
			frenchSpeakingCountries
					.retainAll(regionList.get().stream().map(Country::getName).collect(Collectors.toList()));
		} catch (Throwable e) {
			e.getCause();
		}

		return frenchSpeakingCountries;
	}
}
