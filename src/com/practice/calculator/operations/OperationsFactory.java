package com.practice.calculator.operations;

import com.practice.calculator.Constants;

public class OperationsFactory {
	public static IOperations getOperatorInstance(String operator) {

		switch (operator) {
		case Constants.ADD:
			return new Add();
		case Constants.SUBSTRACT:
			return new Substract();
		case Constants.DIVIDE:
			return new Divide();
		case Constants.MULTIPLY	:
			return new Multiply();
		default:
			return null;
		}

	}
}
