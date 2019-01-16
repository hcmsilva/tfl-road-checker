# tfl-road-checker

A Transport for London Java app app to check the status of TfL roads.

Uses the **MVP design pattern**, **local Unit tests** and **Mockito** for unit test isolation, **Espresso**, flavor dimensions to separate production environment from testing environment (for example providing fake implementations of the Api ie not the same as  Mocks).

- Architecture Pattern: **Model View Presenter (MVP)**
- The app is organized *Feature-per-Package* 
- There is a set of local Unit tests written with **JUnit**
- **Mockito** was used to generate mocks and better isolate these unit tests
- The android library module was developed using TDD and has a considerable amount of Unit / Integration tests
- **Espresso** was used to test the UI


![03](https://user-images.githubusercontent.com/4844875/51235419-592da400-1967-11e9-9c0c-2d8c170205b4.PNG)

# Api configuration
- use of xml to hold api related config -> api_config.xml 
- currently holds root path for TfL api
- can be used for any api related parameters

# Api keys
IMPORTANT: prevent commit of secret keys

- RENAME the dummy_secrets.xml file to secrets.xml (which is gitignore'd)
- fill key/id
- WARNING: THIS DOES NOT PROTECT KEYS AGAINST APK DECOMPILE

```
<resources>
    <string name="tfl_application_id">INSERT_YOUR_APP_ID</string>
    <string name="api_secret">INSERT_YOUR_DEVELOPER_KEY</string>
</resources>
```

# Tests

**Testing with dependency isolation**
The app makes the best use of gradle buildconfigs and flavour variants as necessary for test isolation.
Three major factors help reduce interference from external dependencies:

- Dependency injection (in this case without any external framework)
- Usage of mocked dependencies on unit tests
- Make use of build variants so tests can be conducted with Fake Implementations of the Api


**Espresso tests - Automated End-to-End tests**
- Creation of 'androidTestMock' to separate testing of the UI from the api (uses FakeApiImpl)
- ViewActions and ViewMatchers are used in order to confirm the intended view hierarchy exists
- ViewAssertions are used to assert view content is the intended both after valid and error responses

# Building / running the app and tests

The simplest way to run the app is:

1. Import the app into android studio
2. Select the 'Build Variant' you wish to run
3. Run the default run configuration for the :app module

![02](https://user-images.githubusercontent.com/4844875/51235414-55018680-1967-11e9-9253-994247d53e43.PNG)

Alternatively you may manually run the relevant gradle task to build that variant (either through android studio or by using the gradle wrapper (gradlew) 

example to run all the test src sets
```gradlew test```

example to run the testMockDebug test srcSet 
```gradlew testMockDebug```

# Comments Api

To be perfectly honest I didn't have the chance to explore the API, but I noticed one thing that is worth a comment, usually with RESTful APIs the roadId would be passed as a *query* parameter, not as part of the *path*. It is not serious on the client side, but raises some questions related to the server side, usually a path will be *matched* with a server method on the server which takes the said parameter (ie roadId). With this standard design and with more roads that could represent a problem. 
I also noticed the successful response comes formated as a single element JsonArray instead of a JsonObject maybe for other uses.
    
 

# Screenshots

![03](https://user-images.githubusercontent.com/4844875/51235419-592da400-1967-11e9-9c0c-2d8c170205b4.PNG)


![04](https://user-images.githubusercontent.com/4844875/51235424-5f238500-1967-11e9-8b4b-5078dd3401a7.PNG)


![05](https://user-images.githubusercontent.com/4844875/51235433-6480cf80-1967-11e9-85c7-2433186bf2d2.PNG)


Extra:
Same activity, different icons for the development environment and production for developer convenience

![01_](https://user-images.githubusercontent.com/4844875/51233879-06ea8400-1963-11e9-8ade-14a8b01ecf04.png)


