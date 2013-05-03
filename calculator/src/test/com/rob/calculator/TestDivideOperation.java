package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rob.calculator.operations.DivideOperation;
import com.rob.calculator.operations.ValueOperation;

public class TestDivideOperation {

	@Test
	public void testDivideByZero() throws ParserException{
		double result = new DivideOperation(new ValueOperation(1.0), new ValueOperation(0.0)).evaluate();
		//java returns infinity or NaN when you divide by zero
		assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
	}

}
