package me.deepak.interview.string.regex;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://www.geeksforgeeks.org/find-total-number-of-distinct-years-from-a-string/
*/
public class NumberOfDistinctYears {

	public static void main(String[] args) {
		String input = "For e.g Some random words with date 12-01-1990 and some more words with date 12-12-2017 and again some random words with same date 12-05-1990";

		// regex for date (dd-MM-yyyy) format
		Pattern pattern = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher(input);

		/*
		 * HashSet to store dates as string so that we can return size of this set as
		 * number of distinct dates
		 */
		Set<String> set = new HashSet<>();
		while (matcher.find()) {

			// capture group which is date
			String date = matcher.group();
			String year = date.split("-")[2];
			set.add(year);
		}
		System.out.println(set.size());
	}

}
