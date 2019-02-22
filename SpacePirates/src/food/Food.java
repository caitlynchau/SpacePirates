package food;
public abstract class Food {
	private int nourishmentProvided;
	private int storageSpacesNeeded;
	private String name;
	private int price;
	
	public Food(String n, int p) {
		name = n;
		price = p;
	}

	public int getNourishmentProvided() {
		return nourishmentProvided;
	}

	public void setNourishmentProvided(int nourishmentProvided) {
		this.nourishmentProvided = nourishmentProvided;
	}

	public int getStorageSpacesNeeded() {
		return storageSpacesNeeded;
	}

	public void setStorageSpacesNeeded(int storageSpacesNeeded) {
		this.storageSpacesNeeded = storageSpacesNeeded;
	}
	
	public String toString(){
		return name;
	}

	public void setPrice(int p){
		price = p;
	}
	
	public int getPrice(){
		return price;
	}
}