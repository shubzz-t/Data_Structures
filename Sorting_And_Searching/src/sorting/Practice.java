package sorting;

import java.util.Scanner;
public class Practice {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER THE NO OF ELEMENTS :- ");
		n = scanner.nextInt();

		int[] arr = new int[n];
		System.out.println("ENTER THE " + n + " ELEMENTS :- ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		int length = arr.length-1;
		Practice p = new Practice();
		p.divide(arr , 0 , length);

		p.print(arr);
		scanner.close();
	}

	

	private void divide(int[] arr, int low, int high) {
		
		if (low<high) {
			int mid = (low+high)/2;
			divide(arr, low, mid);
			divide(arr, mid+1, high);
			merge(arr , low , mid , high);
		}
		
	}



	private void merge(int[] arr, int low, int mid, int high) {
		int[] temparr = new int[arr.length];
		int l = low;
		int r = mid+1;
		int k = low;
		
		while (l<=mid && r<=high) {
			if (arr[l]<arr[r]) {
				temparr[k]=arr[l];
				l++;
			}
			else {
				temparr[k]=arr[r];
				r++;
			}
			k++;	
		}
		
		
		if (l>mid) {
			while (r<=high) {
				temparr[k]=arr[r];
				r++;
				k++;
			}
		}
		else {
			while (l<=mid) {
				temparr[k] = arr[l];
				l++;
				k++;
			}
		}
		
		for (int i = low ; i <= high ; i++) {
			arr[i] = temparr[i];
		}
		
	}



	void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i + " ");
		}
	}

}
