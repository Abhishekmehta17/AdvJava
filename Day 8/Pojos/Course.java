package pojos;

public enum Course {
	DAC(160000), DBDA(120000), DITIIS(180000);

	private int fee;

	private Course(int fee) {
		this.fee = fee;
	}

}
