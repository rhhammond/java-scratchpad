package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rob.calculator.operations.AddOperation;
import com.rob.calculator.operations.ValueOperation;

public class TestAddOperation {

	private AddOperation a;
	
	@Test
	public void testEvaluate() {
		a = new AddOperation(new ValueOperation(2.0), new ValueOperation(2.0));
		assertEquals(4.0, a.evaluate(), 0.0);
	}
	
	@Test
	public void testEvaluateNegative(){
		a = new AddOperation(new ValueOperation(-3.0), new ValueOperation(1.0));
		assertEquals(-2.0, a.evaluate(), 0.0);
	}
	
	@Test
	public void testEvaluateZero(){
		a = new AddOperation(new ValueOperation(-3.0), new ValueOperation(3.0));
		assertEquals(0.0, a.evaluate(), 0.0);
	}
}
