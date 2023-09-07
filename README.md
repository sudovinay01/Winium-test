# Winium-test
Sample project to know about winium driver.
## Tech used
- JAVA 17
- Eclipse 2023-06
- testng
- winium driver

## Setup
- clone this repo.
- Install eclipse and also testNg plugin from eclipse market place.
- import into eclipse as Maven project.
- Run "SampleTest.launch" file in project root folder as testNG.

## know issues
If below error message occur add VM argument `--add-opens java.base/java.lang=ALL-UNNAMED`
```
java.lang.RuntimeException: Process refused to die after 10 seconds, and couldn't taskkill it: Unable to make field private final long java.lang.ProcessImpl.handle accessible: module java.base does not "opens java.lang" to unnamed module @59e84876
```
reference: https://www.zucisystems.com/blog/winnium-a-step-by-step-guide/