package bST;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
	
		double cp , sp ,profit; 
		Scanner scanner = new Scanner(System.in);
				System.out.println("ENTER THE SELLING PRICE :- ");
		sp = scanner.nextDouble();
		
		System.out.println("ENTER THE COST PRICE :- ");
		cp = scanner.nextDouble();

		
		profit = sp-cp;
		
		if (sp>cp) {
			System.out.println("PROFIT :- " + profit);
		}
		else {
			System.out.println("LOSS :- " + profit);
		}
		
		scanner.close();
		
	}

}
