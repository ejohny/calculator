package com.practice.calculator;

import com.practice.calculator.parser.OperationPostfixParser;

public class Calculator {
	
	public void calculate(String expression){
		try {
			System.out.println(OperationPostfixParser.parseAndCalculate(expression));
		} catch (Exception e) {
			System.out.println("Incorrect expression "+expression);
			e.printStackTrace();
		}
		
	}
	
	public static void main(String... args) {
		
		Calculator c = new Calculator();
		c.calculate("1 + 2");
	}

}
