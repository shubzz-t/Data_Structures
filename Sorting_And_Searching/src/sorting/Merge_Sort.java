package sorting;

import java.util.Scanner;

public class Merge_Sort {

	private void divide(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			divide(arr, low, mid);
			divide(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int[] temparr = new int[arr.length];
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temparr[k] = arr[i];
				i++;
			} else {
				temparr[k] = arr[j];
				j++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= high) {
				temparr[k] = arr[j];
				j++;
				k++;
			}
		} else {
			while (i <= mid) {
				temparr[k] = arr[i];
				i++;
				k++;
			}
		}

		for (int k2 = low; k2 <= high; k2++) {
			arr[k2] = temparr[k2];
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
		int length = arr.length - 1;
		Merge_Sort m = new Merge_Sort();
		m.divide(arr, 0, length);
		m.print(arr);
	}

}
