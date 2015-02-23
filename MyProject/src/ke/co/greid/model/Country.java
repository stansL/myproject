package ke.co.greid.model;

public class Country {
	private String name;
	private int id;

	public Country() {

	}

	public Country(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Country [name=").append(name).append(", id=")
				.append(id).append("]");
		return builder.toString();
	}

}
