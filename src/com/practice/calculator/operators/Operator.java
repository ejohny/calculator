package com.practice.calculator.operators;

import com.practice.calculator.operations.IOperations;
import com.practice.calculator.operations.OperationsFactory;

public class Operator {

	String name;
	
	int operatorprecedence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOperatorprecedence() {
		return operatorprecedence;
	}

	public void setOperatorprecedence(int operatorprecedence) {
		this.operatorprecedence = operatorprecedence;
	}
	
	public double operate(double a, double b) throws Exception{		
		IOperations ops = OperationsFactory.getOperatorInstance(name);
		if(null != ops){
			return ops.calculate(a, b);
		}
		
		throw new Exception(name +" operator not defined");
					
	}
	

	
}
