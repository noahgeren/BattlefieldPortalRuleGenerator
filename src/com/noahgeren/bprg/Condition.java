package com.noahgeren.bprg;

public class Condition {
	
	private String xml;
	
	protected Condition(String xml) {
		this.xml = xml;
	}
	
	@Override
	public String toString() {
		return xml;
	}
	
	public static Condition alwaysTrue() {
		// TODO
		return new Condition("<block type=\\\"conditionBlock\\\"></block>");
	}

}
