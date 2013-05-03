package com.rob.calculator;

import java.util.EmptyStackException;
import java.util.Stack;

import com.rob.calculator.operations.Operator;

public class InfixCalculator implements ICalculatorBehavior {

	private ReversePolishCalculator rpc;
	
	public InfixCalculator(ReversePolishCalculator rpc){
		this.rpc = rpc;
	}
	
	//convert the string to a postfix string using shunting-yard algorithm then pass it to the reverse polish calculator
	@Override
	public double calculate(String input) throws ParserException {
		//now, use the Reverse Polish Calculator to process the postfix input
		return rpc.calculate(convert(input));
	}

	@Override
	public String convert(String input) throws ParserException {
		StringBuffer postfixInput = new StringBuffer();
		Stack<Operator> operators = new Stack<Operator>();
		Operator currentOperator;
		
		for(char current : input.toCharArray()){
			
			switch(current){

				//skip spaces
				case ' ': break;
				
				//directly append operands to the reverse polish string				
				case '.':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0': 
					postfixInput.append(current);
					break;
				
				//left-associative operators
				case '+':			
				case '-': 		
				case '*':
				case '%':
				case '/':
					currentOperator = Operator.getOperator(current);
					updateOutputForLeftAssociativeOperator(currentOperator, operators, postfixInput);
					operators.push(currentOperator);
					postfixInput.append(' ');
					break;
				
				//right-associative operators			
				case '^':
					currentOperator = Operator.getOperator(current);
					updateOutputForRightAssociativeOperator(currentOperator, operators, postfixInput);
					operators.push(currentOperator);
					postfixInput.append(' ');
					break;				
				
				case '(':
					operators.push(Operator.LEFT_PARENTHESIS);
					break;
					
				case ')':
					try{
						while(operators.peek() != Operator.LEFT_PARENTHESIS) {
							postfixInput.append(' ');
							postfixInput.append(operators.pop().getValue());
						}
						
						//pop the left parenthesis off the stack
						operators.pop();
					}
					catch(EmptyStackException ese){
						throw new ParserException("Error: there is an unclosed parenthesis in the input.");
					}
					break;
					
				default: throw new ParserException(String.format("Invalid character %s", current));
			}
		}
		
		//output the operator stack to the end of the string
		while(!operators.isEmpty()){
			
			if(operators.peek() == Operator.LEFT_PARENTHESIS) 
				throw new ParserException("Error: there is an unclosed parenthesis in the input.");
			
			postfixInput.append(' ');
			postfixInput.append(operators.pop().getValue());
		}
		
		return postfixInput.toString();
	}
	
	//helper method for left associative operators
	private static void updateOutputForLeftAssociativeOperator(Operator o, Stack<Operator> existingOperators, StringBuffer output){
		while(	!existingOperators.isEmpty() && 
				(existingOperators.peek().getPrecedence() <= o.getPrecedence() &&
						existingOperators.peek() != Operator.LEFT_PARENTHESIS)){
			output.append(' ');
			output.append(existingOperators.pop().getValue());
		}
	}
	
	//helper method for right associative operators
	private static void updateOutputForRightAssociativeOperator(Operator o, Stack<Operator> existingOperators, StringBuffer output){
		while(	!existingOperators.isEmpty() && 
				(existingOperators.peek().getPrecedence() < o.getPrecedence() &&
						existingOperators.peek() != Operator.LEFT_PARENTHESIS)){
			output.append(' ');
			output.append(existingOperators.pop().getValue());
		}
	}
	
}
