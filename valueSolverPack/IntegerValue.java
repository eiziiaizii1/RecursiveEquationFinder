package valueSolverPack;

public class IntegerValue extends Value {
	final public int value;

	public IntegerValue(int value) {
		this.value = value;
	}

	@Override
	public Value addition(Value val) {
		IntegerValue typeCastedIntValue = (IntegerValue) val;

		return new IntegerValue(typeCastedIntValue.value + this.value);
	}

	@Override
	public Value subtraction(Value val) {
		IntegerValue typeCastedIntValue = (IntegerValue) val;

		return new IntegerValue(this.value-typeCastedIntValue.value);
	}

	@Override
	public Value multiplication(Value val) {
		IntegerValue typeCastedIntValue = (IntegerValue) val;

		return new IntegerValue(typeCastedIntValue.value * this.value);
	}

	@Override
	public double distance(Value val) {
		return Math.abs(value - ((IntegerValue) val).value);
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof IntegerValue) {
			IntegerValue otherVal = (IntegerValue) obj;
			return this.value==otherVal.value;
		}
		return false;
	}
	
}
