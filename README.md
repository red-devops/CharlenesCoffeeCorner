 Charlenes Coffee Corner
---
The content of the exercise can be found in the file "Swiss Re Coding Exercise Charlene's Coffee Corner.pdf"

### Additional assumptions:
* Promotions are combinable
* If there is an add-on bonus, the cheapest add-on is free
* If there is a drink bonus, the cheapest drink is free
* There is no limit on add-ons

---
### How to run a program

There is an artifact in the root folder with all the required libraries. 
You just need to download the code and in the root folder run the command <br />
```java -jar CharlenesCoffeeCorner.jar <args>```

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
```java -jar CharlenesCoffeeCorner.jar s-coffee add-em bacon-roll orange-juice```

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