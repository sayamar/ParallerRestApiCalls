# ParallerRestApiCalls

Lets say, we have an application to

01- Add @Async  annotation to the function you want to parallelize getCountriesByLanguage and getCountriesByRegion

02- Change the return type of the function by CompletableFuture<List<Country>>

03- Change the return of getCountriesByLanguage and getCountriesByRegion by CompletableFuture.completedFuture(Arrays.asList(response))

04- Change the type of what return getCountriesByLanguage and Region by CompletableFuture<List<Country>>

05- Add a try-catch when you use the completableFuture in your resource

06- Add a .get() in order to use the elements of the list of countries

07- Add throws Throwable to the function getAllEuropeanFrenchSpeakingCountries

08- Add an AsyncConfiguration

The try-catch is not necessary but it is a good reflex to have.To recap, your new code should look like what follows 