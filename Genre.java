import MovieTags.SortTags.Genre;

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
		System.out.println(occurrences + " : " + mTag);
	}
	// function that returns the number of occurrences
	int numOccurrences() {
		return occurrences;
	}
	// functions that returns the movieTag
	String mTag() {
		return mTag;
	}
	@Override
	public int compareTo(MovieTags.SortTags.Genre o) {
		int result = Integer.compare(this.occurrences, o.occurrences);

		if (result == 0) {
			return this.mTag.compareTo(o.mTag);
		}
		return result;
	}

	public String toString() {
		return this.occurrences + ": " + mTag;
	}
}