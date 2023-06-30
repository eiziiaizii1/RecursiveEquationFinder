package valueSolverPack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSolver {
	// Variables
	private String closestString;
	private Value closestValue;
	private double closestDistance;
	private  Value[] inputArr;
	private final Value targetValue;
	private final StringBuilder resultStringBuilder;
	private final String[] Ops = { "+", "-", "*" };
	// Variables

	// Constructor
	public RecursiveSolver(Value[] inputArr, Value targetValue) {
		this.inputArr = inputArr;
		this.targetValue = targetValue;
		resultStringBuilder = new StringBuilder();
		closestString = "";
		closestDistance = Double.MAX_VALUE;
	}


	// Helper Method for mathematical expressions
	private Value getOperation(String op, Value val1, Value val2) {
		return switch (op) {
			case "+" -> val1.addition(val2);
			case "-" -> val1.subtraction(val2);
			case "*" -> val1.multiplication(val2);
			default -> null;
		};

	}
	
	// Helper Method which recursively creates permutations for given inputArray	
	private List<Value[]> generatePermutations (Value[] inputArr,int startIndex){
		List<Value[]> permutations = new ArrayList<>();
		
		if(startIndex>= inputArr.length) {
			permutations.add(inputArr.clone());
			return permutations;
		}
		
		for (int i = startIndex; i < inputArr.length; i++) {
			swap(inputArr, startIndex, i);
			permutations.addAll(generatePermutations(inputArr, startIndex+1));
			//this swap is used to revert swap operation
			swap(inputArr, startIndex, i);
		}
		return permutations;
	}
	
	// Method for swapping array elements
	private void swap (Value[] arr, int a,int b) {
		Value temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	// Helper Method for recursion
	private String initializer() {
		if (inputArr.length == 0) {
			return "Please enter a non-empty input";
		}
		String s;
		List<Value[]> permutations= generatePermutations(inputArr, 0);
		
		//loop which iterates through all possible permutations
		for (Value[] permutationArr: permutations) {
			
			resultStringBuilder.delete(0, resultStringBuilder.length());
			Value startValue= permutationArr[0];
			s = recursiveSolver(startValue,permutationArr,1);
			
			//if we reach the target value, returns exact expression
			if (s != null) {
				return "Result: " + s ;
			}
		}
		//if we don't reach the target value, returns closest expression and value
		if (closestValue.equals(targetValue)) {
			return "Result: " +closestString + " -> " + closestValue;
		}
		return "Couldn't find exact result. Closest result: " + closestString + " -> " + closestValue;

	}

	// Actual Recursion
	private String recursiveSolver(Value proceedingValue,Value[] permutationArr,int index) {
		//return statement for exact solution
		if(permutationArr.length==index) {
			//proceedingValue is the result of the operations that has performed
			if(proceedingValue.distance(targetValue)==0) {
				return resultStringBuilder + " -> " + targetValue;
			}
			//updates closestDistance, whenever exact solution isn't found 
			else {
				double currentDistance= proceedingValue.distance(targetValue);
				if(currentDistance<closestDistance) {
					closestDistance=currentDistance;
					closestValue=proceedingValue;
					closestString=resultStringBuilder.toString();
				}
				return null;
			}
		}
		
		Value nextValue = permutationArr[index];
		
		//appends string for the first operation
		if (resultStringBuilder.length()==0) {
			resultStringBuilder.append(proceedingValue);
		}
		
		for (String op : Ops) {
			//String operations for expression
			String nextOperation = op + nextValue + ")";
			resultStringBuilder.append(nextOperation);
			resultStringBuilder.insert(0, "(");

			//Recursive call
			String StrResult = recursiveSolver(getOperation(op, proceedingValue, nextValue),permutationArr,index+1);

			//Returns StrResult if the exact target value has found
			if (StrResult != null) {
				return StrResult;
			} 
			//Gets closestValue, if it couldn't reach the exact target value
			else {
				double currentDistance = getOperation(op, proceedingValue, nextValue).distance(targetValue);
				if (currentDistance < closestDistance) {
					closestDistance = currentDistance;
					closestString = resultStringBuilder.toString();
					closestValue = getOperation(op, proceedingValue, nextValue);
				}
			}
			//Removes the last operations
			resultStringBuilder.setLength(resultStringBuilder.length() - nextOperation.length());
			//Deletes opening parenthesis
			resultStringBuilder.deleteCharAt(0);
		}
		// returns null, if exact target value hasn't been found
		return null;
	}
	
	private boolean hasSameType(Value[] inputArr) {
		for (int i = 0; i < inputArr.length-1; i++) {
			if(inputArr[i] != null && inputArr[i].getClass()!=inputArr[i+1].getClass()) {
				return false;
			}
		}
		return true;
	}
	
	private String checkSingleElement(Value[] inputArr) {
		for (Value value : inputArr) {
			if (targetValue.equals(value)) {
				return value + "->" + targetValue;
			}
		}
			return null;
	}

	//This function ensures that only the elements that are as the same class as the targetValue remains for operations
	private void typeConverter(Value[] inputArr) {
		int count = 0;
		List<Value> list = new ArrayList<>();
		for (Value value : inputArr) {
			if (value !=null && value.getClass().equals(targetValue.getClass())) {
				list.add(value);
			} else {
				count++;
			}
		}
		Value[] trueList = new Value[inputArr.length-count];
		list.toArray(trueList);
		this.inputArr = trueList;
	}

	//This function makes sure that the array isn't null
	private boolean isNull(Value[] inputArr) {
		int count = 0;
		List<Value> cleanList = new ArrayList<>();
		for (Value value : inputArr) {
			if (value != null) {
				cleanList.add(value);
			}
			else {
				count++;
			}
		}
		if (count == inputArr.length) {
			return false;
		}
			Value[] nonNullList = new Value[inputArr.length-count];
			cleanList.toArray(nonNullList);
			this.inputArr = nonNullList;
			return true;
	}
	
	//Shows the expression and code's execution time 
	public String findExpression() {
		System.out.println("Value pool: "+Arrays.deepToString(inputArr)+" Expected Result: "+targetValue);
		String expression;
		long start = System.nanoTime();

		//Checks if the input array is null and converts the array into a non-null array
		if (!isNull(inputArr)) {
			return "This input is not valid. Please enter a different input.";
		}

		if(!hasSameType(inputArr)) {
			typeConverter(inputArr);
		}
		
		if(checkSingleElement(inputArr)!=null) {
			expression= checkSingleElement(inputArr);
			long end = System.nanoTime();
			double execution = (end - start) / 1000000.0;

	        return expression + "\nTotal execution time:  " + execution + " milliseconds";
		}
		
        expression = initializer();
        long end = System.nanoTime();
        double execution = (end - start) / 1000000.0;

        return expression + "\nTotal execution time:  " + execution + " milliseconds";
    }	
}
