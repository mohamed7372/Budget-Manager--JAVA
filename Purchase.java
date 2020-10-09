package budgetManager;

class Purchase {
	private double price;
	private String name;
	
	public Purchase(double price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s $%.2f", this.getName(), this.getPrice());
	}
}
