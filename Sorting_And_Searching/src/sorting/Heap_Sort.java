package sorting;

import java.util.Scanner;



public class Heap_Sort {

	 // Build heap (rearrange array)
	private void getLargest(int[] arr, int length) {
		for (int i = length/2-1 ; i >= 0 ; i--) {
			heapify(arr  , length , i );
		}
		
		 // One by one extract an element from heap
		for (int i = length-1; i >= 0 ; i--) {
			 // Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			 // call heapify on the reduced heap
			heapify(arr , i , 0 );
		}

	}

	private void heapify(int[] arr  , int length , int i ) {
		int largest = i;  //ELEMENT WHICH WE HAVE TO HEAPIFY
		int l = i*2+1;   //LEFT NODE OF I ELEMENT
		int r = i*2+2;   //RIGHT NODE OF I ELEMENT
		

        // If left child is larger than root
		if (l<length && arr[l]>arr[largest]) {
			largest=l;
		}
		 // If right child is larger than largest so far
		if (r<length && arr[r]>arr[largest]) {
			largest=r;
		}
		//IF THE LARGEST VALUE IS CHANGED BY THE ABOVE 2 CONDITIONS THEN SWAP LARGEST ELEMENT AND THE I POS ELEMENT
		if (largest!=i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			
			//HEAPIFY THE TREE FROM THE ELEMENT WHICH IS SWAPPED 
			heapify(arr , length , largest );
		}
		
	}

	private void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i + " ");
		}

	}

	public static void main(String[] args) {
		System.out.println("ENTER THE NO OF ELEMENTS :- ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		// CREATED AND INSERTED N ARRAY ELEMENTS
		System.out.println("ENTER THE " + n + " ARRAY ELEMENTS :- ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}

		int length = arr.length;
		Heap_Sort h = new Heap_Sort();
		h.getLargest(arr, length);
		h.print(arr);

	}

}
