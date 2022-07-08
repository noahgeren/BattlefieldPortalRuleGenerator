package com.noahgeren.bprg;

public class Value<T> {
	
	private String xml;
	
	protected Value(String xml) {
		this.xml = xml;
	}
	
	public static Value<Integer> getNumber(int number) {
		// TODO
		return new Value<Integer>("");
	}
	
	public static Value<String> getText(String text) {
		// TODO
		return new Value<String>("");
	}
	
	public static Value<Boolean> getBoolean(boolean bool) {
		// TODO
		return new Value<Boolean>("");
	}
	
	@Override
	public String toString() {
		return xml;
	}
	
}
