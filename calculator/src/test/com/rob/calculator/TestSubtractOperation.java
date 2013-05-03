package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rob.calculator.operations.SubtractOperation;
import com.rob.calculator.operations.ValueOperation;

public class TestSubtractOperation {

	private SubtractOperation s;
	
	@Test
	public void testEvaluate() {
		s = new SubtractOperation(new ValueOperation(5.5), new ValueOperation(4.0));
		assertEquals(1.5, s.evaluate(), 0.0);
	}
	
	@Test
	public void testEvaluateNegative(){
		s = new SubtractOperation(new ValueOperation(-3.0), new ValueOperation(1.0));
		assertEquals(-4.0, s.evaluate(), 0.0);
	}
	
	@Test
	public void testEvaluateZero(){
		s = new SubtractOperation(new ValueOperation(3.0), new ValueOperation(3.0));
		assertEquals(0.0, s.evaluate(), 0.0);
	}
}
