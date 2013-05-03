package com.rob.calculator.operations;


public class ValueOperation extends Expression {

	private double value;
	
	public ValueOperation(double value){
		super(null,null);
		this.value = value;
	}
	
	@Override
	public double evaluate() {
		return value;
	}
	
	@Override
	public String toString(){
		return String.format("%.1f", value);
	}
}
