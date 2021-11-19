package sorting;

import java.util.Scanner;

public class Bubble_Sort {
	
	private void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
	}
	
	void print(int[] arr)
	{
		for (int i : arr) {
			System.out.println(i);
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
		
		Bubble_Sort b = new Bubble_Sort(); 
b.bubblesort(arr);
b.print(arr);
	}

	

}
