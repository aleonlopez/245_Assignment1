import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * MovieTags is a class that handles a csv file by reading, sorting, and searching the file.
 * The class prints the 3 highest and 3 lowest movie tags by the number of occurrences
 * that the tag is found in the csv file. Furthermore, the class handles user input for
 * searching the file by tag or by tag count. If the user searches by tag, the number of
 * occurrences of the tag in the file will be printed. If the user searches by count, all 
 * of the tags with the given count will be printed.
 * @author Alex Leon
 */

public class MovieTags {

	public static void main(String[] args) throws FileNotFoundException {
		
		String file = args[0]; // takes filepath from command line
		SortTags tagSorter = new SortTags(file); // creates a new instance of SortTags
		
		tagSorter.outputPopular();
		
		Scanner scan = new Scanner(System.in); // take in user input
		
		System.out.println("Search by Tag or Tag Count? (Enter T or C... or EXIT to exit):");
		// handling user input 
		while (scan.hasNext()) {
			String input = scan.next().toLowerCase();
			scan.nextLine();
			
			if (input.equals("t")) { // handling input "t" for tag
				System.out.println("Tag to search for: ");
				String movieTag = scan.nextLine(); // next line to get input with spaces
				tagSorter.tagSearch(movieTag);
			} else if (input.equals("c")) { // handling input "c" for count
				System.out.println("Count to search for: ");
				String tagOccurrence = scan.next(); // next because there will be no spaces in input
				try {
					int occurrence = Integer.parseInt(tagOccurrence);
					tagSorter.occurrenceSearch(occurrence);
				} catch (Exception e) {
					System.out.println(tagOccurrence + " is not a number.");
				}
			} else if (input.equals("exit")) { // handling when user wants to exit
				scan.close();
				break;
			} else {
				System.out.println("input is invalid");
			}
			System.out.println("Search by Tag or Tag Count? (Enter T or C... or EXIT to exit):");
		}
		System.out.println("Bye!");
	}
}