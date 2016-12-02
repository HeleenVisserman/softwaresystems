package ss.week3;

public class Addition implements OperatorWithIdentity {

	private static final int IDENTITY = 0;
	
	@Override
	public int operate(int left, int right) {
		return left + right;
	}

	@Override
	public int identity() {
		return IDENTITY;
	}

}
