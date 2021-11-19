package Simple_Basics;

import java.util.Scanner;

public class factor {
	public static void main(String[] args) throws java.lang.Exception {
		int c = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				c++;
			}
		}
		System.out.println(c);
		for (int j = 1; j <= n; j++) {
			if (n % j == 0) {
				System.out.print(j + " ");
			}
		}
	}

}
