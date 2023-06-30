package valueSolverPack;

public abstract class Value {
	public abstract Value addition(Value val);
	
	public abstract Value subtraction(Value val);
	
	public abstract Value multiplication(Value val);
	
	public abstract double distance(Value val);
}
