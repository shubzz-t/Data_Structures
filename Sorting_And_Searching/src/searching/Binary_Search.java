package searching;

import java.util.Scanner;

public class Binary_Search {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER THE NO OF ELEMENTS :- ");
		int n = scanner.nextInt();

		System.out.println("ENTER THE " + n + " NO OF ELEMENTS :- ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		System.out.println("ENTER THE DATA TO SEARCH :- ");
		int data = scanner.nextInt();
		scanner.close();

		Binary_Search l = new Binary_Search();
		l.search(arr, data);
	}

	private void search(int[] arr, int data) {
		int low = 0;
		int high = arr.length;
		int middle = (low + high) / 2;

		while (low <= high) {
			if (arr[middle] == data) {
				System.out.println("DATA FOUND AT INDEX :- " + (middle + 1));
			    break;
			} else if (data > arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
			middle = (low + high) / 2;
		}
	}
}
