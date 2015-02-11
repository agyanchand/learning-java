package avi.learning.structures;

class Heap {
	static int[] arr = {5,3,17,10,84,19,6,22,9};
	int len = arr.length,
		left,
		right;
	
	public static void main(String args[]) {
		Heap heap = new Heap();
		heap.printArray(arr);
		heap.createHeap();
		heap.printArray(arr);
		heap.heapSort();
	}
	
	private void printArray(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + "; ");
		}
		System.out.println();
	}
	
	private void createHeap() {
		for(int i=len/2; i>=0; i--) {
			maxHeapify(i);
		}
	}
	
	private void swap(int p, int q) {
		int temp = arr[p];
		arr[p] = arr[q];
		arr[q] = temp;
	}
	
	private void maxHeapify(int idx) {
		left = idx*2+1;
		right = left + 1;
		
		int maxAtIndex = idx;
		
		if(left <= len-1 && arr[left] > arr[idx]) {
			maxAtIndex = left;
		}
		
		if(right <= len-1 && arr[right] > arr[maxAtIndex]) {
			maxAtIndex = right;
		}
		
		if(maxAtIndex != idx) {
			swap(idx, maxAtIndex);
			maxHeapify(maxAtIndex);
		}
	}
	
	private void heapSort() {
		int[] sortedArray = new int[len];
		int i = 0;
		while(len > 0) {
			sortedArray[i++] = popFromHeap();
		}
		
		printArray(sortedArray);
	}
	
	private int popFromHeap() {
		int temp = arr[0];
		swap(0, len-1);
		len--;
		maxHeapify(0);
		return temp;
	}
}