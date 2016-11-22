package com.practice.calculator.parser;

import java.util.Stack;

import com.practice.calculator.Constants;
import com.practice.calculator.operators.Operator;
import com.practice.calculator.operators.OperatorStore;

public class OperationPostfixParser {

	public static Double parseAndCalculate(String expression) throws Exception {

		// convert to post fix and then calculate
		Stack<Operator> operatorStack = new Stack<Operator>();
		Stack<Double> operandStack = new Stack<Double>();

		// use space to sparate all operands and operators
		String[] ooArr = expression.split(" ");
		for (int i = 0; i < ooArr.length; i++) {
			Double number;
			try {
				number = Double.parseDouble(ooArr[i]);
				operandStack.push(number);
			} catch (NumberFormatException nfe) {// not a number so check if its
													// a valid operator

				if (OperatorStore.isValidOperator(ooArr[i])) {

					// this mean its a valid operator.
					Operator o = OperatorStore.getOperatorFromStore(ooArr[i]);
					if (operatorStack.isEmpty()) {// if stack empty add to stack
						operatorStack.push(o);
					} else if (operatorStack.peek().getOperatorprecedence() < o
							.getOperatorprecedence()) {
						operatorStack.push(o);
					} else {
						calculate(operatorStack, operandStack); // if the precedance is equal or less
																// then do the calculation for the
																// previous elements in the stack.
						operatorStack.push(o); // now adding the operator
					}

				} else {

					throw new IllegalArgumentException(
							"Only operators and numbers allowed");
				}
			}

		}
		calculate(operatorStack, operandStack); // all values are added to stack so calculate.
		return operandStack.pop();

	}

	private static void calculate(Stack<Operator> operatorStack,
			Stack<Double> operandStack) throws Exception {
		while ( !operatorStack.isEmpty()
				&& !operatorStack.peek().getName().equals(Constants.OPEN_PARAN)) {

			Operator o = operatorStack.pop();
			double b = operandStack.pop();
			double a = operandStack.pop();
			operandStack.push(o.operate(a, b));
		}
		if(!operatorStack.isEmpty()
				&& operatorStack.peek().getName().equals(Constants.OPEN_PARAN)){
			operatorStack.pop();
		}

	}

}
