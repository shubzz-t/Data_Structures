package sorting;

import java.util.Scanner;

public class Insertion_Sort {

	private void insertion_sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j = j - 1;
			}
			arr[j] = temp;
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

		Insertion_Sort i = new Insertion_Sort();
		i.insertion_sort(arr);
		i.print(arr);
	}

}
