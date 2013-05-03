package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInfixCalculator {

	private InfixCalculator i = new InfixCalculator(new ReversePolishCalculator());
	
	@Test
	public void testOnePlusTwo() {
		double result = 0.0;
		try {
			result = i.calculate("1 + 2");
		} catch (ParserException e) {
			fail();
		}
		assertEquals(3.0, result, 0.0);
	}

	@Test
	public void testParenthesis() {
		double result = 0.0;
		try {
			result = i.calculate("(10 - (1 + 2))*3");
		} catch (ParserException e) {
			fail();
		}
		assertEquals(21.0, result, 0.0);
	}
	
	@Test
	public void testUnclosedLeftParenthesis(){
		try {
			 i.calculate("(10 - (1 + 2)*3");
			 fail();
		} catch (ParserException e) {
			assertEquals("Error: there is an unclosed parenthesis in the input.", e.getMessage());
		}
	}
	
	@Test
	public void testUnclosedRightParenthesis(){
		try {
			 i.calculate("(10 - (1 + 2)))*3");
			 fail();
		} catch (ParserException e) {
			assertEquals("Error: there is an unclosed parenthesis in the input.", e.getMessage());
		}
	}
}
