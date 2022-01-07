# MTTPP-projekt

This is project for Software Testing Methods and Techniques course (hrv. Metode i tehnike testiranja programske podrške). Goal of this project is automation testing of android application. Project will test android application that I have developed for previous course Basics of web and mobile application development (hrv. Osnove razvoja web i mobilnih aplikacija). \
Testing project repo https://github.com/tmarkovica/MTTPP-projekt \
Citys_to_Visit_List application repo https://github.com/tmarkovica/Citys_to_Visit_List

## Tools required for this project

1. Android SDK (Android Studio): https://developer.android.com/studio
2. JDK (Java Development Kit): https://www.guru99.com/install-java.html
3. IDE - IntelliJ: https://www.jetbrains.com/idea/download/#section=windows
4. Test Framework - TestNG: https://mvnrepository.com/artifact/org.testng/testng
5. Selenium-Java: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
6. Node.js: https://nodejs.org/en/download/
7. Appium: https://github.com/appium/appium-desktop/releases/tag/v1.18.3
8. Citys_to_Visit_List.apk: https://github.com/tmarkovica/MTTPP-projekt/blob/master/app-release.apk


## Project setup

### 1. Start Daemon process
- Go to location in terminal: `C:\Users\{username}\AppData\Local\Android\Sdk\platform-tools`
- Type command: `adb devices`

### 2. Run Android emulator
You can run emulator from Android Studio or Windows terminal.

- Check emulator devices installed
- Go to location in terminal: `C:\Users\{username}\AppData\Local\Android\Sdk\emulator`
- Type command: emulator `-avd -list-avds`

- Run emulator device from terminal \
- Go to location in terminal: `C:\Users\{username}\AppData\Local\Android\Sdk\emulator`
- Type command: `emulator -avd {emulator device name}`

### 3. Install app on connected device
- Make sure that apk file is inside "platform-tools" folder: `C:\Users\{username}\AppData\Local\Android\Sdk\platform-tools`
- Type command: `adb install app-release.apk`

### 4. Appium setup
- Set up environment variables by clicking on Edit Configurations \
`ANDROID_HOME = C:\Users\{username}\AppData\Local\Android\Sdk` \
`JAVA_HOME = C:\Program Files (x86)\Java\jre1.8.0_311`
- Click Save and Restart
- Start Server
- When window The server is running appears
- Click on File -> New Session Window
- Then change JSON Representation to this:
```
{
    "app": "C:\\Users\\{username}\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-release.apk",
    "VERSION": "9.0",
    "deviceName": "emulator",
    "platformName": "Android"
}
```

### 5. Change path to apk file
In maven project inside TestRunner class you will have to change "path" attribute so that it's value (path) leads to location of app-release.apk.


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