package com.tcs.angular.angular4.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.angular.angular4.dto.Country;

/**
 * 
 * @author Maruthi Sayampu
 *This is With CompletableFuture means parallel
 */
@Service
public class CountryService {

    RestTemplate restTemplate = new RestTemplate();
    
    @Async
    public CompletableFuture<List<Country>> getCountriesByLanguage(String language){
    	
    	String url = "https://restcountries.eu/rest/v2/lang/" + language + "?fields=name";
		Country[] response = restTemplate.getForObject(url, Country[].class);
		System.out.println(Thread.currentThread().getName());
		return CompletableFuture.completedFuture(Arrays.asList(response));
    	
    }
    @Async
    public CompletableFuture<List<Country>> getCountriesByRegion(String region){
    	String url = "https://restcountries.eu/rest/v2/region/" + region + "?fields=name";
		Country[] response = restTemplate.getForObject(url, Country[].class);
		System.out.println(Thread.currentThread().getName());
		return CompletableFuture.completedFuture(Arrays.asList(response));

    }

}
