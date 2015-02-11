package avi.learning;

public class ArrayFun {
	
	public static void main(String[] args) {
		ArrayFun arrayFun = new ArrayFun();
		arrayFun.playWithIntArray();
		arrayFun.playWithStringArray();
	}
	
	private void playWithIntArray() {
		int[] array = {1,2,3,4,5};
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private void playWithStringArray() {
		String test = "This is a string";
		String[] testArray = test.split("\\b");
		System.out.println(testArray.length);
		
		for(int i=0; i<testArray.length; i++) {
			System.out.println(testArray[i]);
		}
	}
}
