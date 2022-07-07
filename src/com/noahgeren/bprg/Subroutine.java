package com.noahgeren.bprg;

import com.noahgeren.bprg.rules.Condition;

public class Subroutine {
	
	protected String name;
	protected Condition[] conditions;

	protected Subroutine(String name, Condition... conditions) {
		this.name = name;
		this.conditions = conditions;
	}
	
	public Action call() {
		return new SubroutineCall();
	}
	
	private class SubroutineCall implements Action {
		// TODO
	}
	
}
