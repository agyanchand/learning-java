package avi.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class WordsInDigits {
	static Map<Integer, List<String>> digitMap = new HashMap<>();
	static {
		digitMap.put(2, new ArrayList<String>() {{add("a");add("b");add("c");}});
		digitMap.put(3, new ArrayList<String>() {{add("d");add("e");add("f");}});
		digitMap.put(4, new ArrayList<String>() {{add("g");add("h");add("i");}});
		digitMap.put(5, new ArrayList<String>() {{add("j");add("k");add("l");}});
		digitMap.put(6, new ArrayList<String>() {{add("m");add("n");add("o");}});
		digitMap.put(7, new ArrayList<String>() {{add("p");add("q");add("r");add("s");}});
		digitMap.put(8, new ArrayList<String>() {{add("t");add("u");add("v");}});
		digitMap.put(9, new ArrayList<String>() {{add("w");add("x");add("y");add("z");}});
	}
	
	public static void main(String args[]) {
		int[] digits = {2,3,4};
		
		printAllValues(digits, 0, "");
	}
	
	private static void printAllValues(int[] digits, int index, String currentString) {
		if(index == digits.length) {
			System.out.println(currentString);
			return;
		}
		
		List<String> digitArray = digitMap.get(digits[index]);
		
		for(String digit : digitArray) {
			printAllValues(digits, index+1, currentString + digit);
		}
	}
}
