package com.rob.calculator.operations;


public class ModulusOperation extends Expression {

	public ModulusOperation(Expression o1, Expression o2) {
		super(o1, o2);
	}

	@Override
	public double evaluate() {
		//can get a loss of precision here since modulus only handles integer values
		return leftOperand.evaluate() % rightOperand.evaluate();
	}

	@Override
	public String toString(){
		return String.format("(%1$s %% %2$s)", leftOperand, rightOperand);
	}
	
}
