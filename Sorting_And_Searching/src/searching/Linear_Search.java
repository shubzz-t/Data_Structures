package searching;

import java.util.Scanner;

public class Linear_Search {

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
	
		Linear_Search l = new Linear_Search();
		l.search(arr , data);
	}

	void search(int[] arr , int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==data) {
				System.out.println("DATA FOUND AT INDEX :- " + (i+1));
			}
		}
		
	}
	
	
	
	
}
