package com.noahgeren.bprg;

import java.util.LinkedList;
import java.util.List;

import com.noahgeren.bprg.Rule.Event;
import com.noahgeren.bprg.Variable.VariableType;

public class Mod {
	
	protected List<Rule> rules = new LinkedList<>();
	protected List<Variable<?>> variables = new LinkedList<>();
	protected List<Subroutine> subroutines = new LinkedList<>();
	
	protected Mod() {}
	
	public Rule addRule(String name, Event event, Condition... conditions) {
		Rule rule = new Rule(name, event, conditions);
		rules.add(rule);
		return rule;
	}
	
	public <T> Variable<T> addVariable(String name, VariableType type) {
		Variable<T> var = new Variable<>(name, type);
		variables.add(var);
		return var;
	}
	
	public Subroutine addSubroutine(String name, Condition... conditions) {
		Subroutine subroutine = new Subroutine(name, conditions);
		subroutines.add(subroutine);
		return subroutine;
	}

}
