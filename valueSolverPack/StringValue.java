package valueSolverPack;

public class StringValue extends Value {

	public final String value;

	public StringValue(String value) {
		this.value = value;
	}

	@Override
	public Value addition(Value val) {
		StringValue typeCastedStrValue = (StringValue) val;

		return new StringValue(this.value + typeCastedStrValue.value);
	}

	@Override
	public Value subtraction(Value val) {
		StringValue typeCastedStrValue = (StringValue) val;
		int startIndex = this.value.lastIndexOf(typeCastedStrValue.value);
		if (startIndex == -1) {
			return new StringValue(this.value);
		}

		return new StringValue(getDeletedStr(startIndex, typeCastedStrValue));
	}

	// Helper method to subtract a string value
	private String getDeletedStr(int startIndex, StringValue typeCastedStrValue) {
		return this.value.substring(0, startIndex)
				+ this.value.substring(startIndex + typeCastedStrValue.value.length());
	}

	@Override
	public Value multiplication(Value val) {
		StringValue typeCastedStrValue = (StringValue) val;
		StringBuilder multipliedStr = new StringBuilder();
		for (int i = 0; i < this.value.length(); i++) {
			multipliedStr.append(this.value.charAt(i)).append(typeCastedStrValue.value);
		}
		return new StringValue(multipliedStr.toString());
	}

	//Gets the distance by comparing the chars of the original string and the given String
	@Override
	public double distance(Value val) {
	    StringValue typeCastedStrValue = (StringValue) val;

	    int originalStrLength = this.value.length();
	    int newStrLength = typeCastedStrValue.value.length();
	    int lengthChecker = Math.max(originalStrLength, newStrLength);
	    double distance = 0;
	    
	    for (int i = 0; i < lengthChecker; i++) {
	        char ch1 = (i < originalStrLength ? this.value.charAt(i) : ' '); // Character from the original string
	        char ch2 = (i < newStrLength ? typeCastedStrValue.value.charAt(i) : ' '); // Character from the compared string

	        if (ch1 != ch2) {
	            distance++;
	        }
	    }

	    return distance;
	}
	@Override
	public String toString() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof StringValue) {
			StringValue otherVal = (StringValue) obj;
			return this.value==otherVal.value;
		}
		return false;
	}
}
