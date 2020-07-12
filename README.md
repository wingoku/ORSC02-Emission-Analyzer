Dependency Management:

    - Gradle
    
Dependency Injection:

    - Dagger 2
 
Networking Library:

    - Retrofit
    - OKHTTP
    
Reactive Patterns:

    - RxJava
    
Testing Frameworks:

    - JUnit 
    
    
**Compilation From Terminal/CommandLine**

Please run the following commands in the specified order.
If you're trying to execute this code on Windows OS, please use .\gradlew.
On *.nix machines, gradle command would suffice provide gradle is in system variables

Following commands are tested on Windows machine. They should be similar for *nix machines apart from the naming for gradle binary which is gradlew on Windows.

1. Please navigate to root directory of the project, where gradlew dependency resides
2. Run .\gradlew clean
3. Than run .\gradlew build --refresh-dependencies -x test
4. Than run .\gradlew fatJar. This will create an executable for easier interaction with code
5. Gradle will generate this file under PROJECT_ROOT_DIRECTORY/build/libs/*com.wingoku.carbonEmissionCalculator-all-0.1.jar*
6. You can navigate to the above path in terminal or copy this anywhere you like
7. Run *java -jar .\com.wingoku.carbonEmissionCalculator-all-0.1.jar  --start "Los Angeles" --end "New York" --transportation-method=medium-diesel-car*
8. Please add Open Route Service API KEY is set as environment variable
9. You should see output/logs in the terminal.


**Running Tests From Terminal/CommandLine**

Please navigate to the root directory of the project so gradlew binary is accessible
Please run the following commands to run tests from command line

.\gradlew test --tests "com.wingoku.carbonEmissionCalculator.di.modules.MainModuleTest.TEST_METHOD_YOU_WANT_TO_RUN"

*For Example:*

.\gradlew test --tests "com.wingoku.carbonEmissionCalculator.di.modules.MainModuleTest.testValidCmdArgsWithEqualDelimiter"


**Compilation Process IDE:**

Load the project in an IDE supporting Gradle preferably in IntelliJ IDEA (Community Edition or otherwise) &
Sync gradle.

**Setup/Executing Project in IntelliJ IDEA (Community Edition):**


Go to File -> Open than select project from Disk where the attached code zip file was extracted.
Once the project opens in IntelliJ, please go to build menu at the top & select Rebuild Project.
The drop down next to Play button should say "Main", if so, click play. The project should start running.

-------------------------------------
*In case the drop down next to Play button doesn't say "Main":*

Now please go the top right corner next to the PLAY button and click on "Add Configuration".
Click on the + icon on the top left corner and select "Application" from the list.
In Main Class field, paste "com.wingoku.carbonEmissionCalculator.Main" without quotation marks
In Program arguments field, paste  --start "Los Angeles" --end "New York" --transportation-method=medium-diesel-car or the command line arguments
In Environment variable field, paste ORS_TOKEN=YOUR_OPEN_ROUTE_SERVICE_API_KEY
CLick on "Use class path of module" & select com.wingoku.carbonEmissionCalculator.main

Select JRE of your choice from the JRE drop down on the same page.

*Hit Apply & OK. Click the play button. The app should run.*

----------------------------------------
**Providing Environment Variables & CMD args:**

Providing environment variables & command line args in project's configuration as shown in the screenshot
attached with this code. Hit run.

---------------------------------------
**TESTING:**

Please go to the test package, right click on any of the methods decorated with @Test annotation. Click Run "nameOfYourSelectedTestMethod"