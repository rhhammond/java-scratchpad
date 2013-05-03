package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rob.calculator.operations.ValueOperation;

public class TestValueOperation {

	private ValueOperation v;
	
	@Test
	public void testEvaluate() {
		v = new ValueOperation(1.0);
		assertEquals(1.0, v.evaluate(), 0.0);
	}

}
