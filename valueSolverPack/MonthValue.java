package valueSolverPack;


public class MonthValue extends Value {

	Months value;
	
	public MonthValue(Months month) {
		this.value=month;
	}
	
	@Override
	public Value addition(Value val) {
		MonthValue typeCastedMonthValue = (MonthValue) val;
		int sumOfNum=this.value.num + typeCastedMonthValue.value.num;
		return new MonthValue(Months.getMonth(sumOfNum));
	}

	@Override
	public Value subtraction(Value val) {
		MonthValue typeCastedMonthValue = (MonthValue) val;
		int subOfNum=this.value.num - typeCastedMonthValue.value.num;
		return new MonthValue(Months.getMonth(subOfNum));
	}

	@Override
	public Value multiplication(Value val) {
		MonthValue typeCastedMonthValue = (MonthValue) val;
		int multOfNum=this.value.num * typeCastedMonthValue.value.num;
		return new MonthValue(Months.getMonth(multOfNum));
	}

	@Override
	public double distance(Value val) {
		return Math.abs(this.value.num - ((MonthValue) val).value.num);
	}
	
	@Override
	public String toString() {
		return value.name() +"("+ this.value.num+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof MonthValue) {
			MonthValue otherVal = (MonthValue) obj;
			return this.value==otherVal.value;
		}
		return false;
	}
}
