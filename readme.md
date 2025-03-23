Setup Process for the Project

To run the test automation for this project, you need to install the following tools and dependencies:
- Java Development Kit (JDK 11 or later) – Ensure Java is installed and set up correctly by running java -version.
- Appium Server – Install Appium globally using Node.js: npm install -g appium and verify with appium -v.
- Android SDK & ADB – Install Android Studio, set up SDK, and ensure adb devices recognizes your emulator/device.
- Maven – Ensure Apache Maven is installed and configured (mvn -version).
- Appium Inspector (Optional) – Useful for locating elements on the mobile app.
- After setting up the environment, clone this repository, navigate to the project directory, and install dependencies using mvn clean install. Start Appium server (appium) and then run the test using mvn test.

For API, i use RestAssured, just run it in intelij
