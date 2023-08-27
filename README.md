<h1>Parallel Junit4 project</h1>

Please note that this project is still under development!

Some of you might think that if you would like to use Junit4 then you need to give up the parallel running - which is NOT TRUE,
it's still possible with surefire plugin.
I would like to debunk this misconception in this framework.

Expected result: In this test there are 5 passed test, 1 failed and 1 with an error.

To run this project, just simply paste this into the terminal.
```
mvn test -D"cucumber.filter.tags=@smoke"
```

Core technologies:
```
Java8 & Maven
Junit4
Surefire plugin
Selenium - chromedriver
RestAssured
```

The project uses a chromedriver v.116, probably you will need to replace it with the newest one.
