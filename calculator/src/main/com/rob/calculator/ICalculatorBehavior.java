package com.rob.calculator;

public interface ICalculatorBehavior {
	double calculate(String input) throws ParserException;
	String convert(String input) throws ParserException;
}
