import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieTags {

	public static void main(String[] args) throws FileNotFoundException {
		
		String file = args[0]; // takes filepath from command line
		//MovieTags mt = new MovieTags(); // creates a new instance of MovieTags
		SortTags tagSorter = new SortTags(file); // creates a new instance of nested class SortTags using MovieTags
		
		//tagSorter.outputPopular();
		
		Scanner scan = new Scanner(System.in); // take in user input
		
		System.out.println("Search by Tag or Tag Count? (Enter T or C... or EXIT to exit):");
		// handling the user input 
		while (scan.hasNext()) {
			String input = scan.next().toLowerCase();
			scan.nextLine();
			
			if (input.equals("t")) {
				System.out.println("Tag to search for: ");
				String movieTag = scan.next();
				System.out.println(movieTag);
				tagSorter.tagSearch(movieTag);
			} else if (input.equals("c")) {
				//System.out.println("Count to search for: ");
				//String tagOccurrence = scan.next();
//				if (input) { //try catch or isDigit with 
//					int occurrence = Integer.parseInt(tagOccurrence);
//					tagSorter.occurrenceSearch(occurrence);
//				} else {
//					System.out.println(tagOccurrence + " is not a number.");
//				}
				
			} else if (input.equals("exit")) {
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

