package Simple_Basics;

import java.util.Scanner;

public class IS_BOTH {
	public static void main(String[] args)
	{
		
		  
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();

		 if ((n%5==0 && n%11!=0)||(n%5!=0 && n%11==0)) {
			System.out.println("ONE");
		}
		 else if (n%5==0 && n%11==0) {
			System.out.println("BOTH");
		}
		 else {
			System.out.println("NONE");
		}
}
}
	
	