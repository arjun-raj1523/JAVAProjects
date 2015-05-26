public class Date {
	int dd;
	int mm;
	int yy;

	public Date() {

	}

	public Date(int dd, int mm, int yy) {
		super();
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
	}

	@Override
	protected void finalize() {
		System.out.println(this);
		System.out.println("Garbage Collector Initalized");

	}

}
