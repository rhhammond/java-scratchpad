package com.rob.calculator;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

import com.rob.calculator.operations.AddOperation;
import com.rob.calculator.operations.DivideOperation;
import com.rob.calculator.operations.ExponentialOperation;
import com.rob.calculator.operations.Expression;
import com.rob.calculator.operations.ModulusOperation;
import com.rob.calculator.operations.MultiplyOperation;
import com.rob.calculator.operations.Operator;
import com.rob.calculator.operations.SubtractOperation;
import com.rob.calculator.operations.ValueOperation;

public class ReversePolishCalculator implements ICalculatorBehavior{

	@Override
	public double calculate(String input) throws ParserException {
		return buildExpression(input).evaluate();
	}

	@Override
	public String convert(String input) throws ParserException {
		return buildExpression(input).toString();
	}
	
	private Expression buildExpression(String input) throws ParserException{
		
		Stack<Expression> operations = new Stack<Expression>();
		
		//tokenize the string on empty spaces between operands and operators
		StringTokenizer t = new StringTokenizer(input, " ");
		Operator o = null;
		Expression left, right;
		
		while (t.hasMoreElements()) {

			String currentToken = t.nextToken();
			try {				
				//first try to parse for an operand, and push it to the stack
				operations.push(new ValueOperation(Double.parseDouble(currentToken)));
			} catch (NumberFormatException nfe) {
				//now try to parse an operator
				try{
					o = Operator.getOperator(currentToken);
				}
				catch(IllegalArgumentException iae){
					//when the token still can't be parsed, it is an invalid character
					throw new ParserException(String.format("Error: Unknown operator '%s'", currentToken));
				}
				try{
					//right operand will be at the top of the stack, left operand will be second on the stack.  
					//an EmptyStackException will be thrown if there are not enough operators on the stack.
					right = operations.pop();
					left = operations.pop();
					
					//push the new operator on the stack with the operands as arguments (decorator pattern)
					switch(o){
						case ADD: 	
							operations.push(new AddOperation(left, right));
							break;
									
						case SUBTRACT: 								
							operations.push(new SubtractOperation(left, right));							
							break;
							
						case MULTIPLY:
							operations.push(new MultiplyOperation(left, right));
							break;
							
						case DIVIDE:
							operations.push(new DivideOperation(left, right));
							break;
							
						case EXPONENT:
							operations.push(new ExponentialOperation(left, right));
							break;
							
						case MODULO:
							operations.push(new ModulusOperation(left, right));
							break;
					}
				}
				catch(EmptyStackException ese){
					throw new ParserException("Error: There are more operators than operands.");
				}
			}
		}
		
		// empty string was input, just return 0
		if (operations.isEmpty())
			return new ValueOperation(0);

		// throw exception, not enough operators
		if (operations.size() > 1) {
			throw new ParserException("Error: There are more operands than operators.");
		}

		return operations.pop();
	}

}
