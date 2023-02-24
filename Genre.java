/*
 * Genre is a class that handles the genres by keeping the occurrences of the tags
 * and the tags. Also, the class is used to compare the occurrences of the genres
 * to confirm that the tag being returned is correct.
 * @author Alex Leon
 */


public class Genre implements Comparable<Genre> {

	String mTag = new String();
	int occurrences;

	Genre(String movieTag) {
		mTag = movieTag;
		occurrences = 1;
	}
	// function to increment occurrences
	void increment() {
		occurrences++;
	}
	// function that prints the output with the movie tag and its occurrences
	void output() {
		System.out.println(occurrences + ": " + mTag);
	}
	// function that returns the number of occurrences
	int numOccurrences() {
		return occurrences;
	}
	// functions that returns the movieTag
	String mTag() {
		return mTag;
	}
	//comparing the occurrences to return the correct tag
	@Override
	public int compareTo(Genre o) {
		int result = Integer.compare(this.occurrences, o.occurrences);

		if (result == 0) {
			return this.mTag.compareTo(o.mTag);
		}
		return result;
	}
	// toString to convert output to string
	public String toString() {
		return this.occurrences + ": " + mTag;
	}
}