package com.yahoo.calculator.operations;

public class Divide implements IOperations {

	@Override
	public double calculate(double a, double b) {
		if(b == 0) throw new IllegalArgumentException("Divisor should not be 0");
		return a/b;
	}

}
