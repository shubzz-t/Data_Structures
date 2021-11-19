package Simple_Basics;

public class while_loop {

	public static void main(String[] args) {
		int n = 16;
		int count = 0;

		while (n > 0) {
			n = n / 2;
			count++;
			System.out.println(count);
		}
		
	}
}
