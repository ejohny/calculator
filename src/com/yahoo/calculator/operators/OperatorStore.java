package com.yahoo.calculator.operators;

import java.util.HashMap;

import com.yahoo.calculator.Constants;

public class OperatorStore {

	static HashMap<String, Operator> store = new HashMap<String, Operator>();
	
	static {
		addDefaultOperators();
	}

	private static void addDefaultOperators() {
		
		addDefaultOperator(Constants.ADD, 100);
		addDefaultOperator(Constants.SUBSTRACT, 100);
		addDefaultOperator(Constants.MULTIPLY, 50);
		addDefaultOperator(Constants.DIVIDE, 50);
		addDefaultOperator(Constants.OPEN_PARAN, 25);
		addDefaultOperator(Constants.CLOSED_PARAN, 150);
	}
	
	private static void addDefaultOperator(String name, int precedance) {
		Operator o = new Operator();
		o.setName(name);
		o.setOperatorprecedence(precedance);
		store.put(name, o);
		
	}

	public static void setStore(HashMap<String, Operator> st) {
		store = st;
	}

	public static HashMap<String, Operator> getStore() {
		return store;
	}
	
	public static Operator getOperatorFromStore(String operator) {
		return store.get(operator);
	}
	
	public static boolean isValidOperator(String operator) {
		return store.containsKey(operator);
	}
	
	
}
