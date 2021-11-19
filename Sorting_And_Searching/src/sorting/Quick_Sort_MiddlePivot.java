package sorting;

import java.util.Scanner;

public class Quick_Sort_MiddlePivot {

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

		int length = arr.length-1;
		
		Quick_Sort_MiddlePivot q = new Quick_Sort_MiddlePivot();
		q.divide(arr , 0 , length);
		q.print(arr);

	}

	
	private void divide(int[] arr, int low, int high) {
		int mid = quick(arr , low , high);
		if (low<mid-1) {
			divide(arr, low, mid-1);
		}
		if (high>mid) {
			divide(arr, mid, high);
		}
	}
	
	private int quick(int[] arr, int low, int high) {
		int pivot = arr[(low+high)/2];
		
		while (low<=high) {
			while (arr[low]<pivot) {
				low++;
			}
			while (arr[high]>pivot) {
				high--;
			}
			if (low<=high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			   low++;
			   high--;
			}
		}
		return low;
	}


	private void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i + " ");
		}		
	}


}
