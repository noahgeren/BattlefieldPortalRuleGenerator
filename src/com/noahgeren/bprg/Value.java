package com.noahgeren.bprg;

public class Value<T> {
	
	Value() {}
	
	public static Value<Integer> getNumber(int number) {
		return new NumberLiteral(number);
	}
	
	public static Value<String> getText(String text) {
		return new TextLiteral(text);
	}
	
	public static Value<Boolean> getBoolean(boolean bool) {
		return new BooleanLiteral(bool);
	}
	
	private static class NumberLiteral extends Value<Integer> {
		
		private int number;
		
		private NumberLiteral(int number) {
			this.number = number;
		}
		
	}
	
	private static class TextLiteral extends Value<String> {
		
		private String text;
		
		private TextLiteral(String text) {
			this.text = text;
		}
		
	}
	
	private static class BooleanLiteral extends Value<Boolean> {
		
		private boolean bool;
		
		private BooleanLiteral(boolean bool) {
			this.bool = bool;
		}
		
	}
	
}
