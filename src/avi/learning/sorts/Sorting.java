package avi.learning.sorts;

public class Sorting {
	private int[] array;
	
	public static void main(String args[]) {
		Sorting sorting = new Sorting();
		sorting.buildArray();
		sorting.bubbleSort();
		sorting.buildArray();
		sorting.selectionSort();
		sorting.buildArray();
		sorting.insertionSort();
		sorting.buildArray();
		sorting.mergeSort();
	}
	
	private void buildArray() {
		array = new int[]{6,9,1,3,23,45,12,5,7,16,11,23,65,73,78,2,33,47,1,64,0};
		printArray("Building Array:-");
	}
	
	private void printArray(String message) {
		System.out.println(message);
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + "; ");
		}
		
		System.out.println();
		System.out.println();
	}
	
	private void swapElements(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void bubbleSort() {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j< array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					swapElements(j, j+1);
				}
			}
		}
		
		printArray("Bubble Sorted:-");
	}
	
	private void selectionSort() {
		for(int i=0; i<array.length; i++) {
			int minIndex = i,
					currentMin = array[i];
			for(int j=i; j< array.length; j++) {
				if(array[j] < currentMin) {
					minIndex = j;
					currentMin = array[j];
				}
			}
			
			if(minIndex != i) {
				swapElements(i, minIndex);
			}
		}
		
		printArray("Selection Sorted:-");
	}
	
	private void insertionSort() {
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j>0; j--) {
				if(array[j] > array[j-1]) {
					break;
				}
				swapElements(j, j-1);
			}
			
		}
		
		printArray("Insertion Sorted:-");
	}
	
	private void mergeSort() {
		mergeSort(0, array.length - 1);
		printArray("Merge Sorted:-");
	}
	
	private void mergeSort(int low, int high) {
		if(low < high) {
			int middle = (low + high) / 2;
			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		int[] helper = new int[array.length];
		for(int i=0; i<=high; i++) {
			helper[i] = array[i];
		}
		
		int i = low,
			j = middle + 1,
			lowerBound = low;
		
		while (i<=middle && j<=high) {
			if(helper[i] <= helper[j]) {
				array[lowerBound] = helper[i++];
			} else {
				array[lowerBound] = helper[j++];
			}
			lowerBound++;
		}
		
		while (i<=middle) {
			array[lowerBound++] = helper[i++];
		}
		
		while (j<=high) {
			array[lowerBound++] = helper[j++];
		}
	}
}