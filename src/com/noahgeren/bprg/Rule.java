package com.noahgeren.bprg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.noahgeren.bprg.rules.Condition;
import com.noahgeren.bprg.rules.Event;

public class Rule {
	
	protected String name;
	protected Event event;
	protected Condition[] conditions;
	protected List<Action> actions = new LinkedList<>();
	
	protected Rule(String name, Event event, Condition... conditions) {
		this.name = name;
		this.event = event;
		this.conditions = conditions;
	}
	
	public Rule addActions(Action... actions) {
		this.actions.addAll(Arrays.asList(actions));
		return this;
	}

}
