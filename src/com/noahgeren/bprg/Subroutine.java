package com.noahgeren.bprg;

public class Subroutine {
	
	private String name;
	private Condition[] conditions;

	protected Subroutine(String name, Condition... conditions) {
		this.name = name;
		this.conditions = conditions;
	}
	
	public Action call() {
		return new Action("");
	}
}
