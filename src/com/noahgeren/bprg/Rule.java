package com.noahgeren.bprg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rule {

	private String name;
	private Event event;
	private Condition[] conditions;
	private List<Action> actions = new LinkedList<>();

	private static final List<Event> ONGOING_EVENTS = Arrays.asList(Event.ONGOING_GLOBAL, Event.ONGOING_CAPTURE_POINT,
			Event.ONGOING_PLAYER, Event.ONGOING_TEAM, Event.ONGOING_VEHICLE);

	protected Rule(String name, Event event, Condition... conditions) {
		this.name = name;
		this.event = event;
		this.conditions = conditions;
	}

	public Rule addActions(Action... actions) {
		this.actions.addAll(Arrays.asList(actions));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder conditionXml = new StringBuilder();
		for(Condition condition : conditions) {
			conditionXml.append(condition.toString());
		}
		StringBuilder actionXml = new StringBuilder();
		actions.forEach(action -> actionXml.append(action.toString()));
		return String.format(
				"<block type=\\\"ruleBlock\\\">"
				+ "<mutation isOnGoingEvent=\\\"%b\\\"></mutation>"
				+ "<field name=\\\"NAME\\\">%s</field>"
				+ "<field name=\\\"EVENTTYPE\\\">%s</field>"
				+ "<statement name=\\\"CONDITIONS\\\">%s</statement>"
				+ "<statement name=\\\"ACTIONS\\\">%s</statement>"
				+ "</block>", 
				ONGOING_EVENTS.contains(event), name, event.getName(), conditionXml.toString(), actionXml.toString());
	}

	public static enum Event {
		// TODO
		ONGOING_GLOBAL(""), ONGOING_CAPTURE_POINT(""), ONGOING_PLAYER(""), ONGOING_TEAM(""), ONGOING_VEHICLE(""), ON_PLAYER_DIED("OnPlayerDied");
		
		private String name;
		
		private Event(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}

}
