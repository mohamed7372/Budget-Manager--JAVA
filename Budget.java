package budgetManager;

import java.util.ArrayList;

class Budget {
	double balance;
	ArrayList<Purchase> purchases;

	public Budget() {
		this.balance = 0;
		this.purchases = new ArrayList<Purchase>();
	}
	
	public void addPurchase(String name, double price) {
		if(balance > 0) {
			balance -= price;
			if(balance < 0)
				balance = 0;
			purchases.add(new Purchase(price, name));
		}
	}
	public void totalSum() {
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) 
			total += purchases.get(i).getPrice();
		System.out.printf("Total sum: $%.2f\n",total);
	}
}