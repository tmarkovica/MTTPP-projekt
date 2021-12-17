# RELEASE NOTES
__Citys_to_Visit_List__
Android application intended to give out traveling ideas.

## Release Features
### Feature 1
In the *ExploreActivity* there is button "Random" that starts search for random city in the world and lists it's basic information: name, country, region, population, timnezone.

### Feature 2
In the *ExploreActivity* there is switch button through which you can get that citys location on Google Maps.

### Feature 3
Cities that get liked are stored in the *FavoritesActivity*. From there you can access citys Wikipedia page.


## Enchancements
### Echancement 1
When exploring, searching for cities, when searching for next city the previous one gets lost if it isn't added to favorites by liking it. It can happen that user unintentionally relocates to another activity or starts serch for the next city and then loses last search. Undo button is good solution for this and also including redo button in order to navigate through search history.

### Enhancment 2
Cities that are saved in favorites can not be shown in Google Maps again. Clicking on the city in favorites will redirect you to activity where you will be able to toggle between city information and location on Google Maps.

## Known Issues and Problems
### Issue 1
When you exit from *ExploreActivity* back to *MainActivity* or go to *FavoritesActivity* city information dissappears.
#### Workaround
Like button gives option to add randomly found city to favorites so it can be found in *FavoritesActivity* and from there user can access Wikipedia page of that city by clicking on the city name and then url to Wiki page.

### Issue 2
API works with only 1 request/second. That means when searching for city you can get search results for at most one city every second.