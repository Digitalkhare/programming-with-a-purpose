
public class Bar implements Comparable<Bar> {

	private String name;
	private int value;
	private String category;

	// Creates a new bar.
	public Bar(String name, int value, String category) {
		if (name == null)
			throw new IllegalArgumentException("name is null");
		if (value < 0)
			throw new IllegalArgumentException("value is negative");
		if (category == null)
			throw new IllegalArgumentException("category is null");

		this.name = name;
		this.value = value;
		this.category = category;
	}

	// Returns the name of this bar.
	public String getName() {
		return name;
	}

	// Returns the value of this bar.
	public int getValue() {
		return value;
	}

	// Returns the category of this bar.
	public String getCategory() {
		return category;
	}

	// Compare two bars by value.
	@Override
	public int compareTo(Bar that) {
		if (that == null)
			throw new NullPointerException("BAr argument is null");
		if (value < that.value) {
			return -1;
		} else if (value > that.value) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
