To run on a Unix-based terminal:
  $ java -jar GroceriesScraper
  
A file groceries.json will be output containing the Json information scraped from the sainsbury's website.

For tests and packageing maven is required.

To run tests use:
  $ mvn test
  
  
To package the program use:
  $ mvn clean compile assembly:single
  
creates a .jar file in target directory.
  
