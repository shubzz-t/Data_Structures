package sorting;

import java.util.Scanner;

public class Quick_Sort_FirstPivot {

	void partition(int[] arr, int low, int high) {
		if (low < high) {
			int mid = quick(arr, low, high);
			partition(arr, low, mid - 1);
			partition(arr, mid + 1, high);
		}
	}

	private int quick(int[] arr, int low, int high) {
		int pivot = low ; 
		int i = low+1;
		
		for (int j = low+1 ; j < arr.length; j++) {
			if (arr[j]<arr[pivot]) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i+=1;
			}
			
		}
		int temp = arr[low];
		arr[low] = arr[i-1];
		arr[i-1] = temp;
		return i-1;
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
		int length = arr.length - 1;

		Quick_Sort_FirstPivot q = new Quick_Sort_FirstPivot();
		q.partition(arr, 0, length);
		q.print(arr);
	}

	

}
