/**
 * 
 */
package com.tcs.angular.angular4.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.angular.angular4.dto.Country;

/**
 * @author Maruthi Sayampu
 * 
 * This is Without CompletableFuture means not parallel
 *
 */
@Service
public class CountryClient {

	RestTemplate restTemplate = new RestTemplate();

	public List<Country> getCountriesByLanguage(String language) {
		String url = "https://restcountries.eu/rest/v2/lang/" + language + "?fields=name";
		Country[] response = restTemplate.getForObject(url, Country[].class);

		return Arrays.asList(response);

	}

	public List<Country> getCountriesByRegion(String region) {
		String url = "https://restcountries.eu/rest/v2/region/" + region + "?fields=name";
		Country[] response = restTemplate.getForObject(url, Country[].class);

		return Arrays.asList(response);
	}

}
