import java.util.*;

/*
 * Cracking the Coding Interview - 6th Edition
 * 
 * Chapter 1 
 * 
 * Arrays and Strings 
 * 
 */

public class ArraysAndStrings {
	
	/*
	 * Chapter 1 - Arrays and Strings 
	 * Driver
	 */
	
	public static void main(String[] args) {
		// Problem 1.1
			String input = "dabcd";
				isUnique(input);
		// Problem 1.2
			String str1 = "tacocat";
			String str2 = "ccoaatt";
				checkPermutation(str1, str2);
	}
	
	
    /* Problem 1.1 - Is Unique
	 * Implement an Algorithm to determine if a string has all unique characters.
	 * What if you cannot use additional data structures?
	 */
	
	public static boolean isUnique(String str) {
		System.out.println("Problem 1.1");
		System.out.println("------------------------");
		
		// O(n^2) Solution
		
		/*
		if (str.length() > 128) return false; // Assuming Character Set is ASCII
		
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					System.out.println("The string " + str + " is not unique.");
					return false;
				}
			}
		}
		System.out.println("The string " + str + "\n" + "is unique.");
		return true;
		*/
		
		// O(n) Solution
		
		if (str.length() > 128) return false; // Assuming Character Set is ASCII
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i); 
			//System.out.println(index);
			if (char_set[index]) {	// Char has already been found in the string
				System.out.println("The string " + str + " is not unique." + "\n");
				return false;
			}
			char_set[index] = true;
		}
		System.out.println("The string " + str + "\n" + "is unique." + "\n");
		return true;
	}
	
	/* Problem 1.2 - Check Permutation
	 * Given two Strings, write a method to decide if one is a permutation of the other
	 */
	
	public static boolean checkPermutation(String str1, String str2) { 
		System.out.println("Problem 1.2");
		System.out.println("------------------------");
		
		if (str1.length() != str2.length()) {
			System.out.println("Different string lengths cannot be permutations of each other." + "\n");
			return false;
		}
		
		// Converting both strings to char arrays
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		// Sorting both new char arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// Converting char arrays back into strings
		String str_1 = String.valueOf(arr1);
		String str_2 = String.valueOf(arr2);
		
		if (str_1.equals(str_2)) {
			System.out.println("String " + str1 + " is a permutation of " + str2 + "." + "\n");
			return true;
		}
		System.out.println("String " + str1 + " is not a permutation of " + str2 + "." + "\n");
		return false;
	}
	
	/* Problem 1.3
	 * 
	 */
}


