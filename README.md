<h1>Parallel Junit4</h1>

Please note that this project is still under development!

A some thinks that, if you would like to use Junit4, you need to give up the parallel running - which is not true,
it's still possible with surefire plugin.
I would like to debunk this misconception in this framework.

To run this project, just simply paste this into the terminal.
```
mvn test -D"cucumber.filter.tags=@smoke"
```

Used technologies:
```
Java8 & Maven
Junit4
Surefire plugin
Selenium - chromedriver
RestAssured
```

The project uses a chromedriver v.116, probably you will need to replace it with the newest one.
