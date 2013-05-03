package com.rob.calculator.operations;

//Expression follows the decorator pattern (composition and inheritance)
public abstract class Expression {
	
	protected Expression leftOperand;
	protected Expression rightOperand;
	
	public Expression(Expression leftOperand, Expression rightOperand){
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	abstract public double evaluate();
}