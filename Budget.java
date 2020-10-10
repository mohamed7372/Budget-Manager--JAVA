package budgetManager;

import java.util.ArrayList;

class Budget {
	double balance;
	ArrayList<Purchase> purchases;

	public Budget() {
		this.balance = 0;
		this.purchases = new ArrayList<Purchase>();
	}
	
	public void addPurchase(String name, double price, Type type) {
		if(balance > 0) {
			balance -= price;
			if(balance < 0)
				balance = 0;
			purchases.add(new Purchase(price, name, type));
		}
	}
	public void totalSum() {
		double total = 0;
		for (int i = 0; i < purchases.size(); i++) 
			total += purchases.get(i).getPrice();
		System.out.printf("Total sum: $%.2f\n",total);
	}
	public void totalSum(Type type) {
		double total = 0;
		for (int i = 0; i < purchases.size(); i++)
			if(purchases.get(i).getType() == type)
				total += purchases.get(i).getPrice();
		System.out.printf("Total sum: $%.2f\n",total);
	}
	public double sum(Type type) {
		double total = 0;
		for (int i = 0; i < purchases.size(); i++)
			if(purchases.get(i).getType() == type)
				total += purchases.get(i).getPrice();
		return total;
	}

	public void sort(){
        for (int i = 0; i < purchases.size() - 1; i++) {
            for (int j = 0; j < purchases.size() - i - 1; j++) {
                if(purchases.get(j).getPrice() < purchases.get(j + 1).getPrice()) {
                	Purchase p = purchases.get(j);
                	purchases.set(j, purchases.get(j+1));
                	purchases.set(j+1, p);
                }
            }
        }
        for (int i = 0; i < purchases.size(); i++) {
			System.out.println(purchases.get(i).toString());
		}
    }
}
