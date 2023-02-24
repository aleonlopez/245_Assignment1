import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * SortTags is a class that handles a csv file by reading, sorting, and searching.
 * The class also finds the 3 highest and 3 lowest movie tags by the number of occurrences
 * that the tag is found in the csv file. 
 * @author Alex Leon
 */
public class SortTags {

	ArrayList<String> known = new ArrayList<String>(); // ArrayList containing known tags
	ArrayList<Genre> genreUnsorted = new ArrayList<Genre>(); // ArrayList containing unsorted genre and tag pairs 
	ArrayList<Genre> genreSorted = new ArrayList<Genre>(); // ArrayList containing genre and tag pairs in sorted order

	public SortTags(String file) throws FileNotFoundException {

		Scanner scan = new Scanner(new File(file)); // read the file
		scan.nextLine(); // skips first line in file

		while (scan.hasNextLine()) {
			String movieTag = scan.nextLine().split(",")[2].trim(); // split lines at "," and trim
			int index = known.indexOf(movieTag);

			if(index != -1) { 
				// if movie tag is known increment
				genreUnsorted.get(index).increment();
				genreSorted.get(index).increment();
			} else { 
				// if movie tag is not known, then add the movie tag to both genre ArrayLists
				known.add(movieTag);
				Genre movieUnsorted = new Genre(movieTag);
				Genre movieSorted = new Genre(movieTag);
				genreUnsorted.add(movieUnsorted);
				genreSorted.add(movieSorted);
			}
		}
		scan.close();
		Collections.sort(genreSorted); // sorts the genreSorted array 
	}
	// function that prints the top 3 and lowest 3 tags by occurrence
	public void outputPopular() {
		// prints the 3 most popular movie tags by occurrence
		System.out.println("*** Highest 3 movies by count ***");
		for (int i = 1; i < 4; i++) {
			genreSorted.get(genreSorted.size() - i).output();
		}
		//prints the 3 least popular movie tags by occurrence
		System.out.println("*** Lowest 3 movies by count ***");
		for (int i = 0; i < 3; i++) {
			genreSorted.get(i).output();
		}
	}
	// search for the tags with the num of occurrences that the user inputs
	public void occurrenceSearch(int occurrences) {
		System.out.println("Tags with " + occurrences + " occurences");

		int size = genreSorted.size();
		int maxOccurrences = genreSorted.get(size - 1).numOccurrences();
		boolean flag = false;

		for (int i = 0; i < genreSorted.size() && genreSorted.get(i).numOccurrences() <= occurrences; i++) {
			if (occurrences <= 0 || occurrences > maxOccurrences) {
				break;
			}
			if (genreSorted.get(i).numOccurrences() == occurrences) {
				System.out.println("* " + genreSorted.get(i).mTag());
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("No tags with " + occurrences + " occurrences exists.");
		}
	}
	// search for the occurrences of the tag that the user inputs
	public void tagSearch(String movieTag) {
		int i = known.indexOf(movieTag); // getting the index of the known tag
		boolean flag = false;

		if (i >= 0 && i < genreSorted.size()) {
			int occurrence = genreUnsorted.get(i).numOccurrences();
			System.out.println("Tag \"" + movieTag + "\" occurred " + occurrence + " times.");
			flag = true;
		}
		if (flag == false || i == -1) {
			System.out.println("Tag \"" + movieTag + "\" does not exist.");
		}
	}
}
