package budgetManager;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Budget budget = new Budget();
	
	public static void main(String[] args) {
		int fin = 0;
		while(fin == 0) {
			menu();
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				addIncome();
				break;
			case 2:
				addPurchase();
				break;
			case 3:
				listPurchases();
				break;
			case 4:
				balance();
				break;
			case 0:
				fin =1;
				break;
			}
			System.out.println();
		}
		System.out.println("Bye!");
	}
	
	static void menu() {
		System.out.println("Choose your action:");
		System.out.println("1) Add income");
		System.out.println("2) Add purchase");
		System.out.println("3) Show list of purchases");
		System.out.println("4) Balance");
		System.out.println("0) Exit");
	}
	
	static void addIncome() {
		System.out.println("\nEnter income:");
		budget.balance = Double.parseDouble(sc.nextLine());
		System.out.println("Income was added!");
	}
	static void balance() {
		System.out.printf("\nBalance: $%.2f\n",budget.balance);
	}
	static void listPurchases() {
		if(budget.purchases.size() == 0)
			System.out.println("\nPurchase list is empty");
		else {
			System.out.println();
			for (int i = 0; i < budget.purchases.size(); i++) {
				System.out.println(budget.purchases.get(i));
			}
			budget.totalSum();
		}
	}
	static void addPurchase() {
		System.out.println("\nEnter purchase name:");
		String name = sc.nextLine();
		System.out.println("Enter its price:");
		double price = Double.parseDouble(sc.nextLine());
		budget.addPurchase(name, price);
		System.out.println("Purchase was added!");
	}
}
