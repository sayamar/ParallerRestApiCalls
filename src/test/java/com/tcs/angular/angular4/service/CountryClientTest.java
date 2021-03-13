package com.tcs.angular.angular4.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tcs.angular.angular4.dto.Country;

public class CountryClientTest {
	
	private CountryClient countryClient;
	
	@Before
	public void setUp() {
		countryClient = Mockito.spy(new CountryClient());	
	}
	
	@Test
    public void getCountryByLanguage() throws ExecutionException, InterruptedException {
        List<Country> countriesByLanguage = countryClient.getCountriesByLanguage("fr");
        assertNotNull(countriesByLanguage);
        System.out.println(countriesByLanguage.get(0).getName());
        assertEquals("Belgium", countriesByLanguage.get(0).getName());
    }

}
