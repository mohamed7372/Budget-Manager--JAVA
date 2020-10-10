package budgetManager;

enum Type {
	Food(1),
	Clothes(2),
	Entertainment(3),
	Other(4);
	
	int num;
	
	Type(int num){
		this.num = num;
	}
	
	int getNum() {
		return this.num;
	}
}
