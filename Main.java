package budgetManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
			case 5:
				saveData();
				break;
			case 6:
				loadData();
				sc = new Scanner(System.in);
				break;
			case 0:
				fin =1;
				break;
			}
			System.out.println();
		}
		System.out.print("Bye!");
	}
	
	static void menu() {
		System.out.println("Choose your action:");
		System.out.println("1) Add income");
		System.out.println("2) Add purchase");
		System.out.println("3) Show list of purchases");
		System.out.println("4) Balance");
		System.out.println("5) Save");
		System.out.println("6) Load");
		System.out.println("0) Exit");
	}
	static void purchaseMenu() {
		System.out.println("\nChoose the type of purchase");
		System.out.println("1) Food");
		System.out.println("2) Clothes");
		System.out.println("3) Entertainment");
		System.out.println("4) Other");
		System.out.println("5) Back");
	}
	static void purchaseListMenu() {
		System.out.println("\nChoose the type of purchase");
		System.out.println("1) Food");
		System.out.println("2) Clothes");
		System.out.println("3) Entertainment");
		System.out.println("4) Other");
		System.out.println("5) All");
		System.out.println("6) Back");
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
			int fin = 0;
			while(fin == 0) {
				purchaseListMenu();
				int ch = Integer.valueOf(sc.nextLine());
				switch (ch) {
				case 1:
					listTypePurchase(Type.Food,"Food");
					break;
				case 2:
					listTypePurchase(Type.Clothes,"Clothes");
					break;
				case 3:
					listTypePurchase(Type.Entertainment,"Entertainment");
					break;
				case 4:
					listTypePurchase(Type.Other,"Other");
					break;
				case 5:
					if(budget.purchases.size() == 0)
						System.out.println("\nPurchase list is empty");
					else {
						System.out.println("\nAll:");
						for (int i = 0; i < budget.purchases.size(); i++) {
							System.out.println(budget.purchases.get(i));
						}
						budget.totalSum();
					}
					break;
				case 6:
					fin = 1;
					break;
				}
			}
		}
	}
	static void listTypePurchase(Type type, String title) {
		int n = 0;
		System.out.println("\n" + title + ":");
		for (int i = 0; i < budget.purchases.size(); i++) {
			if(budget.purchases.get(i).getType() == type) {
				System.out.println(budget.purchases.get(i));
				n++;
			}
		}
		if(n > 0)
			budget.totalSum(type);
		else
			System.out.println("Purchase list is empty");
	}
	static void addPurchase() {
		int fin = 0;
		Type type = null;
		while(fin == 0) {
			purchaseMenu();
			int ch = Integer.valueOf(sc.nextLine());
			switch (ch) {
			case 1:
				type = Type.Food;
				break;
			case 2:
				type = Type.Clothes;
				break;
			case 3:
				type = Type.Entertainment;
				break;
			case 4:
				type = Type.Other;
				break;
			case 5:
				fin = 1;
				break;
			}
			if(fin == 0 && type != null) {
				System.out.println("\nEnter purchase name:");
				String name = sc.nextLine();
				System.out.println("Enter its price:");
				double price = Double.parseDouble(sc.nextLine());
				budget.addPurchase(name, price, type);
				System.out.println("Purchase was added!");
			}
		}
	}

	static void saveData() {
		File f = new File("C:\\Users\\HP\\eclipse-work\\zhard7\\src\\budgetManager\\purchases.txt");
		try {
            if(!f.exists())
                f.createNewFile();
            FileWriter fw = new FileWriter(f);
            if(budget.purchases.size() > 0) {
                fw.write(String.format("%.2f", budget.balance));
                for (int i = 0; i < budget.purchases.size(); i++) {
                    fw.append("\n" + budget.purchases.get(i).allInfo());
                }
            }
            System.out.println("\nPurchases were saved!");
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	static void loadData() {
		File f = new File("C:\\Users\\HP\\eclipse-work\\zhard7\\src\\budgetManager\\purchases.txt");
		try {
            if(f.exists()) {
                sc = new Scanner(f);
                if(sc.hasNext())
                    budget.balance = Double.parseDouble(sc.nextLine());
                while(sc.hasNext()) {
                    String s = sc.nextLine();
                    String[] data = sc.nextLine().split("\\$");
                    Type type = null;
                    if(s.equals("1"))
                        type = Type.Food;
                    else if(s.equals("2"))
                        type = Type.Clothes;
                    else if(s.equals("3"))
                        type = Type.Entertainment;
                    else if(s.equals("4"))
                        type = Type.Other;
                    
                    if(data[data.length-1].matches("\\d+.\\d+")) {
                    	String name = data[0];
                    	for (int i = 1; i < data.length-1; i++) 
							name += "$" + data[i];
                        Purchase p = new Purchase(Double.parseDouble(data[data.length-1]), name.trim(), type);
                        budget.purchases.add(p);
                    }
                }
                System.out.println("\nPurchases were loaded!");
                sc.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
