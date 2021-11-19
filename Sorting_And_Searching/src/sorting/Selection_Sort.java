package sorting;

import java.util.Scanner;

public class Selection_Sort {
	private void selection_sort(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
			int min=i;
	    	for (int j = i+1; j < arr.length; j++) {
				if (arr[min]>arr[j]) {
					min=j;
				}
			}
	    	int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
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
		
		//CREATED AND INSERTED N ARRAY ELEMENTS
		System.out.println("ENTER THE " + n + " ARRAY ELEMENTS :- ");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		Selection_Sort s = new Selection_Sort();
		s.selection_sort(arr);
		s.print(arr);

	}

	

}
