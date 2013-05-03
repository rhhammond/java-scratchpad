package com.rob.calculator.operations;

public class MultiplyOperation extends Expression {

	public MultiplyOperation(Expression o1, Expression o2){
		super(o1,o2);
	}
	
	@Override
	public double evaluate() {		
		return leftOperand.evaluate() * rightOperand.evaluate();
	}

	@Override
	public String toString(){
		return String.format("(%1$s * %2$s)", leftOperand, rightOperand);
	}
	
}
