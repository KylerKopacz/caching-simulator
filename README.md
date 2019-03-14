# Caching Simulator
A caching simulator for various types of cache replacement policies, written in Java.

We tested 4 different caching policies against 3 different data request distributions.

The distributions were from a Uniform, a Zipf, and from a distribution with high temporal locality.

The caching policies implemented:
1. Random Replacement
2. Least Recently Used (LRU) Replacement
3. First In, First Out (FIFO) Replacement
4. Least Frequently Used (LFU) Replacement

To run the simulation:
1. Make sure all java files are within the same directory
2. Compile the java files with:
```
javac *.java
```
3. Then, run the simulator.
```
java CacheSimulator
```

The simulation should print out the results of each test to the console, and also export data to a .csv file called "results.csv".

We have also provided javadoc documenation for the project, which can be found by:
1. Cloning the repository
2. Navigating to the "/DOCS/" folder
3. Double clicking "index.html"

That should open up the documentation files in the browser, allowing you to navigate the different classes and see how they work.
