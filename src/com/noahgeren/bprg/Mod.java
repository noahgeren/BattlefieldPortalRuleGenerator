package com.noahgeren.bprg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.noahgeren.bprg.Rule.Event;
import com.noahgeren.bprg.Variable.CapturePointVariable;
import com.noahgeren.bprg.Variable.GlobalVariable;
import com.noahgeren.bprg.Variable.PlayerVariable;
import com.noahgeren.bprg.Variable.TeamVariable;
import com.noahgeren.bprg.Variable.VehicleVariable;

public class Mod {

	private List<Rule> rules = new LinkedList<>();
	private List<Variable<?>> variables = new LinkedList<>();
	private List<Subroutine> subroutines = new LinkedList<>();

	protected Mod() {
	}

	public Rule addRule(String name, Event event, Condition... conditions) {
		Rule rule = new Rule(name, event, conditions);
		rules.add(rule);
		return rule;
	}
	
	public Subroutine addSubroutine(String name, Condition... conditions) {
		Subroutine subroutine = new Subroutine(name, conditions);
		subroutines.add(subroutine);
		return subroutine;
	}

	public <T> GlobalVariable<T> addGlobalVariable(String name) {
		GlobalVariable<T> var = new GlobalVariable<>(name);
		variables.add(var);
		return var;
	}

	public <T> CapturePointVariable<T> addCapturePointVariable(String name) {
		CapturePointVariable<T> var = new CapturePointVariable<>(name);
		variables.add(var);
		return var;
	}
	
	public <T> PlayerVariable<T> addPlayerVariable(String name) {
		PlayerVariable<T> var = new PlayerVariable<>(name);
		variables.add(var);
		return var;
	}
	
	public <T> TeamVariable<T> addTeamVariable(String name) {
		TeamVariable<T> var = new TeamVariable<>(name);
		variables.add(var);
		return var;
	}
	
	public <T> VehicleVariable<T> addVehicleVariable(String name) {
		VehicleVariable<T> var = new VehicleVariable<>(name);
		variables.add(var);
		return var;
	}

	@Override
	public String toString() {
		// TODO: Make sure this works
		StringBuilder variableXml = new StringBuilder();
		variables.forEach(variable -> variableXml.append(variable.toString()));
		StringBuilder subroutineXml = new StringBuilder();
		subroutines.forEach(subroutine -> subroutineXml.append(subroutine.toString()));
		StringBuilder ruleXml = new StringBuilder();
		rules.forEach(rule -> ruleXml.append(rule.toString()));
		return String.format(
				"{\"mainWorkspace\": \"<xml xmlns=\\\"https://developers.google.com/blockly/xml\\\"><variables>%s</variables>%s<block type=\\\"modBlock\\\" deletable=\\\"false\\\" x=\\\"0\\\" y=\\\"0\\\"><statement name=\\\"RULES\\\">%s</statement></block></xml>\",\r\n"
				+ "\"variables\": \"<variables xmlns=\\\"https://developers.google.com/blockly/xml\\\">%s</variables>\"}",
				variableXml.toString(), subroutineXml.toString(), ruleXml.toString(), variableXml.toString());
	}

}
