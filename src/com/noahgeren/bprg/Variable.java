package com.noahgeren.bprg;

import com.noahgeren.bprg.types.CapturePoint;
import com.noahgeren.bprg.types.Player;
import com.noahgeren.bprg.types.Team;
import com.noahgeren.bprg.types.Vehicle;

public abstract class Variable<T> {
	
	private String name;
	private String type;
	
	private Variable(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("<variable type=\\\"%s\\\" id=\\\"%s_%s\\\">%s</variable>", type, type.toLowerCase(), name, name);
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
			// TODO
			return new Action("");
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
			// TODO
			return new Action("");
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
			// TODO
			return new Action("");
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
			// TODO
			return new Action("");
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
			// TODO
			return new Action("");
		}
	}
	
}
