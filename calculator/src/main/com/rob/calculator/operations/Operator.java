package com.rob.calculator.operations;

public enum Operator {
	ADD("+", 4),
	SUBTRACT("-", 4),
	MULTIPLY("*", 3),
	DIVIDE("/", 3),
	MODULO("%", 3),
	EXPONENT("^", 2),
	LEFT_PARENTHESIS("(", 1);
	
	private final String value;
	private final int precedence;
	
	Operator(String s, int p){
		value = s;
		precedence = p;
	}
	
	public static Operator getOperator(String value) throws IllegalArgumentException{
		for(Operator o : Operator.values()){
			if(o.value.equals(value)) return o;
		}
		throw new IllegalArgumentException();
	}
	
	public static Operator getOperator(char value) throws IllegalArgumentException{
		return getOperator(String.valueOf(value));
	}
	
	public int getPrecedence(){
		return precedence;
	}
	
	public String getValue(){
		return value;
	}
	
}
