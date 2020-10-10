package budgetManager;

class Purchase {
    private double price;
    private String name;
    private Type type;

    public Purchase(double price, String name, Type type) {
        this.price = price;
        this.name = name;
        this.type = type;
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
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", this.getName(), this.getPrice());
    }
    public String allInfo() {
        return getType().getNum() + "\n" + getName() + " $" + getPrice();
    }
    public void changeInfo(Type type, String name, double price) {
    	this.name = name;
    	this.price = price;
    	this.type = type;
    }
}
