package com.noahgeren.bprg;

import java.util.LinkedList;
import java.util.List;

import com.noahgeren.bprg.Variable.VariableType;
import com.noahgeren.bprg.rules.Condition;
import com.noahgeren.bprg.rules.Event;

public class Mod {
	
	private List<Rule> rules = new LinkedList<>();
	private List<Variable<?>> variables = new LinkedList<>();
	private List<Subroutine> subroutines = new LinkedList<>();
	
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
