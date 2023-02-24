# Movie Tags
MovieTags.java is a project for CS245 Data Structures and Algorithms. The objective of this project is to demonstrate mastery of object oriented design, searching and sorting algorithms by handling a large dataset efficiently with respect to time and space. This is done by reading a csv file which contains information on movies. The program takes the data, sorts it, and prints the three most and three least popular movie tags. Furthermore, the user can search for specific information, by movie tag or a count of a movie tag(s), that they would like to find. Depending on the search, the program will print the number of times the movie tag was found in the file or all of the movie tags with the given number of occurrences in the file.

# Complexity Analysis

**Reading the Data File**

Reading the data file is O(n) runtime. When reading the file, I use indexOf(), which is O(n) runtime, to get the index of the known movie tag from the known ArrayList. I use the index to check if the tag is known or not. If the movie tag is known, I increment, which happens in O(n) runtime, the occurrence of the movie tag at the index. If not, I add the unknown movie tag to each of the 3 ArrayLists.

**List Most and Least Popular Tags**

Listing the most and least popular tags occurs in O(n lg n) runtime. I used Collections.sort(), which is O(n log n), and Comparable in the Genre class to sort the genreSorted ArrayList by occurrence in ascending order. Once sorted, I utilize .get() to output the first 3 values, least popular, and the last 3 values, most popular, in the ArrayList.

**Search by Count**

Searching by count is O(n) runtime. The genreSorted ArrayList is searched through using a linear search. I used a for loop which terminates if the count is less or less than zero or if the count is greater than the given count. Therefore, if one of those conditions is met, the runtime would be constant, O(1), becuase the search never occurs.

**Search by Tag**

Searching by tag is O(n) runtime. The search uses indexOf(), which is O(n) runtime, to get the index of the known movie tag from the known ArrayList. This index matches the index of the genreUnsorted ArrayList, which has the count of the occurrences of the tag being searched for. The count is then used to print the corresponding output. 
