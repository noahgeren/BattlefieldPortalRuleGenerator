package com.noahgeren.bprg;

public class Action {

	private String xml;
	
	protected Action(String xml) {
		this.xml = xml;
	}
	
	@Override
	public String toString() {
		return xml;
	}
	
}
