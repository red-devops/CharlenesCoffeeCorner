 Charlenes Coffee Corner
---
The content of this project is part of the post on blog https://red-devops.pl/<br>
The purpose of this repository is to familiarize us with the basic tasks that GitHub Actions can perform.  
In this project, we use GitHub Actions to perform CI of an application that supports a small store.<br>
The requirements for the application can be found in the file "Swiss Re Coding Exercise Charlene's Coffee Corner.pdf"

### Additional assumptions:
* Promotions are combinable
* If there is an add-on bonus, the cheapest add-on is free
* If there is a drink bonus, the cheapest drink is free
* There is no limit on add-ons

---
### How to run a program

To run the program download the code and build the jar using the mvn package command, the jar will be located in the targed folder. <br />
```java -jar CharlenesCoffeeCorner-1.0-SNAPSHOT.jar <args>```

Arguments available:
- s-coffee      (small coffee)
- m-coffee      (medium coffee)
- l-coffee      (large coffee)
- add-em        (extra milk)
- add-fm        (foamed milk)
- add-rc        (special roast coffee)
- bacon-roll    (bacon roll)
- orange-juice  (orange juice)

Example:<br />
```java -jar CharlenesCoffeeCorner-1.0-SNAPSHOT.jar s-coffee add-em bacon-roll orange-juice```

Output:<br />
```
Small coffee....2.5 CHF
Extra milk....0.3 CHF
Bacon roll....4.5 CHF
Orange juice....3.95 CHF
Bonus Extra milk....-0.3 CHF
TOTAL: 10.95 CHF
```
---
### Requirements
- Java 8+
- JUnit 5.7.0