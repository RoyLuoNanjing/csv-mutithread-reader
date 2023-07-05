# csv-mutithread-reader


This Java program is designed to merge multiple CSV files into a single file based on a unique identifier (User ID). It utilizes a multithreaded approach to enhance the reading speed. Measures have been taken to handle concurrency issues and prevent conflicts during the writing process. The program also incorporates the Inversion of Control design pattern and Dependency Injection.

Tech Stack: Java 8
Instructions:
  To run the program, navigate to src/Solution.java.
  
Test Samples:
  To set the test CSV files, go to src/data.
  Sample CSV files stored in the dev folder contain a small amount of data (100 records each).
  Sample CSV files stored in the live folder contain a larger amount of data (250,000 records each).
  To add your own files (more than 5), please add a new entity into src/dao/entity.
  

Result: To find the resulting merged file, navigate to src/data/result.csv.
