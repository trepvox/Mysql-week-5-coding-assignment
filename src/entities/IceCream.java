package entities;

public class IceCream {

	private int id;
	private String flavor;
	
	public IceCream(int id, String flavor) {
		this.setId(id);
		this.setFlavor(flavor);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	
}
