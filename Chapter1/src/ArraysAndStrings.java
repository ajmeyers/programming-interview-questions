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
	
	/* Problem 1.3 - URLify
	 * Write a method to replace all spaces in a string with with '%20'. You may assume that the string
	 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
	 * length of the string.
	 */
	
	public static void URLify(char[] str, int length) {
		System.out.println("Problem 1.3");
		System.out.println("------------------------");
		System.out.println(str);
		
		int spaceCount = 0, index = 0, i = 0;

		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		//System.out.println(spaceCount);
		// Extra space acquired to insert '%20' for each blank space in spaceCount
		index = length + (spaceCount * 2);
		System.out.println("length " + length);
		System.out.println("str.length " + str.length);
		if (length < str.length) str[length] = '\0';
		
		for (i = length-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			}
			else {
				str[index - 1] = str[i];
				index--;
			}
		}
		System.out.print(str);
	}
	
	/*
	 * Chapter 1 - Arrays and Strings 
	 * Driver
	 */
	
	public static void main(String[] args) {
		// Problem 1.1
			//String input = "dabcd";
				//isUnique(input);
		// Problem 1.2
			//String str1 = "tacocat";
			//String str2 = "ccoaatt";
				//checkPermutation(str1, str2);
		// Problem 1.3
			char[] str = {'a',' ','b',' ','c','d',' ',' ',' ',' '}; // result should be "a%20b%20cd" 
			int length = 6;
				URLify(str, length);		
	}
}


