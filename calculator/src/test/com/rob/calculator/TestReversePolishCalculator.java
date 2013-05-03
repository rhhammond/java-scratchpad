package com.rob.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReversePolishCalculator {

	private ReversePolishCalculator p = new ReversePolishCalculator();
	
	@Test
	public void testCalculateWithEmptyInput() throws ParserException {
		double result = p.calculate("");
		assertEquals(0.0, result, 0.0);
	}

	@Test
	public void testCalculateWithSpaceInput() throws ParserException{
		double result = p.calculate(" ");
		assertEquals(0.0, result, 0.0);
	}
	
	@Test
	public void testCalculateWithAllOperations() throws ParserException{
		//  (((9+7-6+5) * 2 / 3) ^ 2) % 9 = 1
		double result = p.calculate("7 9 + 6 - 5 + 2 * 3 / 2 ^ 9 %");
		assertEquals(1.0, result, 0.0);
	}
	
	@Test
	public void testTooManyOperands(){
		try{
			p.calculate("1 2 3 +");
			fail("Expecting a ParserException, there are 3 operands but only 1 operator.");
		}
		catch(ParserException pe){
			assertEquals("Error: There are more operands than operators.", pe.getMessage());
		}
	}
	
	@Test
	public void testTooManyOperators(){
		try{
			p.calculate("1 2 + -");
			fail("Expecting a ParserException, there are 2 operators but only 2 operands.");
		}
		catch(ParserException pe){
			assertEquals("Error: There are more operators than operands.", pe.getMessage());
		}
	}
	
	@Test
	public void testInvalidInputMissingSpace(){
		try{
			p.calculate("1 2+");
			fail("Expecting the input to fail because it has improper spacing.");
		}
		catch(ParserException pe){
			assertEquals("Error: Unknown operator '2+'", pe.getMessage());
		}
	}
	
	@Test
	public void testSubtractionIsLeftAssociative(){
		try{
			double result = p.calculate("1 2 -");
			assertEquals(-1.0, result, 0.0);
		}
		catch(ParserException pe){
			fail();
		}
	}
	
	@Test
	public void testDivisionIsLeftAssociative(){
		try{
			double result = p.calculate("1 2 /");
			assertEquals(.5, result, 0.0);
		}
		catch(ParserException pe){
			fail();
		}
	}
	
	@Test
	public void testModulusIsLeftAssociative(){
		try{
			double result = p.calculate("9 5 %");
			assertEquals(4.0, result, 0.0);
		}
		catch(ParserException pe){
			fail();
		}
	}
}
