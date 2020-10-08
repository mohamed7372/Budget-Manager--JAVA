package budgetManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<String> purchase = new ArrayList<String>();
		double total = 0;
		while(sc.hasNext()) {
			String input = sc.nextLine();
			purchase.add(input);
			String[] str = input.split("\\$");
			total += Double.parseDouble(str[1]);
		}
		purchase.forEach(x -> System.out.println(x));
		System.out.println("\nTotal: $" + total);
	}
}
