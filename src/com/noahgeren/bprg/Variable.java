package com.noahgeren.bprg;

public class Variable<T> {
	
	protected String name;
	protected VariableType type;
	
	protected Variable(String name, VariableType type) {
		this.name = name;
		this.type = type;
	}
	
	public Value<T> get() {
		return new VariableValue();
	}
	
	public SettingVariable set(Value<T> value) {
		return new SettingVariable(value);
	}
	
	public static enum VariableType {
		GLOBAL, CAPTURE_POINT, PLAYER, TEAM, VEHICLE;
	}
	
	private class VariableValue extends Value<T> {
		private VariableValue() {
			// TODO
		}
	}
	
	private class SettingVariable implements Action {
		
		private Value<T> value;
		
		private SettingVariable(Value<T> value) {
			this.value = value;
			// TODO
		}
		
	}
	
	

}
