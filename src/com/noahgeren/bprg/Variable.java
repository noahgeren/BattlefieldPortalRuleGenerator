package com.noahgeren.bprg;

import com.noahgeren.bprg.types.CapturePoint;
import com.noahgeren.bprg.types.Player;
import com.noahgeren.bprg.types.Team;
import com.noahgeren.bprg.types.Vehicle;

public abstract class Variable<T> {
	
	private String name;
	private String type;
	
	private static final String SET_VARIABLE_FORMAT = "<block type=\\\"SetVariable\\\">"
			+ "<value name=\\\"VALUE-0\\\">"
			+ "<block type=\\\"variableReferenceBlock\\\">"
			+ "<mutation isObjectVar=\\\"true\\\"></mutation>"
			+ "<field name=\\\"OBJECTTYPE\\\">%s</field>"
			+ "<field name=\\\"VAR\\\" id=\\\"%s\\\" variabletype=\\\"%s\\\">%s</field>"
			+ "%s"
			+ "</block>"
			+ "</value>"
			+ "<value name=\\\"VALUE-1\\\">%s</value>"
			+ "</block>";
	
	private Variable(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	private String getId() {
		return String.format("%s_%s", type.toLowerCase(), name);
	}
	
	private String getForObject(Value<?> object) {
		if(object == null) return "";
		return String.format("<value name=\\\"OBJECT\\\">%s</value>", object.toString());
	}
	
	protected Action getSetVariableAction(Value<T> value, Value<?> forObject) {
		return new Action(String.format(SET_VARIABLE_FORMAT, type, getId(), type, name, getForObject(forObject), value.toString()));
	}
	
	@Override
	public String toString() {
		return String.format("<variable type=\\\"%s\\\" id=\\\"%s\\\">%s</variable>", type, getId(), name);
	}
	
	public static class GlobalVariable<T> extends Variable<T> {
		protected GlobalVariable(String name) {
			super(name, "Global");
		}

		public Value<T> get() {
			// TODO
			return new Value<T>("");
		}
		
		public Action set(Value<T> value) {
			return getSetVariableAction(value, null);
		}
	}
	
	public static class CapturePointVariable<T> extends Variable<T> {
		protected CapturePointVariable(String name) {
			super(name, "CapturePoint");
		}

		public Value<T> get(Value<CapturePoint> capturePoint) {
			// TODO
			return new Value<T>("");
		}
		
		public Action set(Value<T> value, Value<CapturePoint> capturePoint) {
			return getSetVariableAction(value, capturePoint);
		}
	}
	
	public static class PlayerVariable<T> extends Variable<T> {
		protected PlayerVariable(String name) {
			super(name, "Player");
		}

		public Value<T> get(Value<Player> player) {
			// TODO
			return new Value<T>("");
		}
		
		public Action set(Value<T> value, Value<Player> player) {
			return getSetVariableAction(value, player);
		}
	}
	
	public static class TeamVariable<T> extends Variable<T> {
		protected TeamVariable(String name) {
			super(name, "TeamId");
		}

		public Value<T> get(Value<Team> team) {
			// TODO
			return new Value<T>("");
		}
		
		public Action set(Value<T> value, Value<Team> team) {
			return getSetVariableAction(value, team);
		}
	}
	
	public static class VehicleVariable<T> extends Variable<T> {
		protected VehicleVariable(String name) {
			super(name, "Vehicle");
		}

		public Value<T> get(Value<Vehicle> vehicle) {
			// TODO
			return new Value<T>("");
		}
		
		public Action set(Value<T> value, Value<Vehicle> vehicle) {
			return getSetVariableAction(value, vehicle);
		}
	}
	
}
